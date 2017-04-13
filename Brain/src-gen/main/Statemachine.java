package main;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Vector;

import org.yakindu.scr.ITimer;
import org.yakindu.scr.TimerService;

public class Statemachine {
	private String statemachineName;
	private Object statemachine = null;
	private Class<?> statemachineClass = null;
	
	public Statemachine() {
		this("");
	}
	
	public Statemachine(String statemachineName) {
		try {
			if (statemachineName == null || statemachineName.isEmpty()) {
				System.err.println("Getting statemashine failed bacause statemachineName is empty");
				return;
			}
			
			//Get Class by statemachineName
			this.statemachineClass = Class.forName("org.yakindu.scr." + statemachineName.toLowerCase() + "." + statemachineName + "Statemachine");
			
			//Erst wenn Zuweisung geklappt hat, setze Name
			this.statemachineName = statemachineName;
			
			// new instance of selected statemashine
			this.statemachine = this.statemachineClass.newInstance();
			
			// setTime()
			Method setTime = statemachineClass.getDeclaredMethod("setTimer", new Class[] { ITimer.class });
			setTime.invoke (statemachine, new TimerService());
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean setOperationCallbacks(){
//		t.brain.getSCIBGF().setSCIBGFOperationCallback(new OpCallbackImplBGF());
//		t.brain.getSCIVBrain().setSCIVBrainOperationCallback(new OpCallbackImplVBrain());
//		t.brain.getSCIHBrain().setSCIHBrainOperationCallback(new OpCallbackImplHBrain());
//		t.brain.getSCIAttractiveness().setSCIAttractivenessOperationCallback(new OpCallbackImplAttractiveness());
//		t.brain.getSCIKinect2().setSCIKinect2OperationCallback(new OpCallbackImplKinect2());
//		t.brain.getSCILeapMotion().setSCILeapMotionOperationCallback(new OpCallbackImplLeapMotion());
//		t.brain.getSCIMira().setSCIMiraOperationCallback(new OpCallbackImplMira());
//		t.brain.getSCISTT().setSCISTTOperationCallback(new OpCallbackImplSTT());
//		t.brain.getSCICurrPerson().setSCICurrPersonOperationCallback(new OpCallbackImplCurrPerson());
		
		if (this.statemachine != null) {

			Vector<String> opCallbackImplNames = new Vector<String>();
			
			// Get used SCI's from statemachine
			Method[] methods = statemachineClass.getDeclaredMethods();
			for (Method method : methods) {
				if (method.getName().startsWith("getSCI")) {
					opCallbackImplNames.add(method.getName().substring(6));
				}
			}
			System.out.println("opCallbackImplNames: " + opCallbackImplNames.toString());
						
			for (String opCallbackImplName : opCallbackImplNames) {
				try {
					Method getSCI = this.statemachineClass.getDeclaredMethod("getSCI" + opCallbackImplName, new Class[]{});
					Object sci = getSCI.invoke(this.statemachine);
					Class<?> sciClass = sci.getClass();
					Class<?> sciOperationCallback = Class.forName("org.yakindu.scr." + this.statemachineName.toLowerCase() + ".I" + this.statemachineName + "Statemachine$SCI" + opCallbackImplName + "OperationCallback");
					Class<?> opCallbackImplClass = Class.forName("callbacks.OpCallbackImpl" + opCallbackImplName);
					Method setSCIOperationCallback = sciClass.getDeclaredMethod("setSCI" + opCallbackImplName + "OperationCallback", new Class[]{sciOperationCallback});
					setSCIOperationCallback.invoke(sci, opCallbackImplClass.newInstance());	
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
			}

			return true;
		}else{
			System.err.println("setOperationCallbacks failed because statemashine not set");
			return false;
		}
	}
	
	public boolean initAndEnter(){
		if (this.statemachine != null) {
			try {
				Method init = statemachineClass.getDeclaredMethod("init", new Class[]{});
				Method enter = statemachineClass.getDeclaredMethod("enter", new Class[]{});
				init.invoke (statemachine);
				enter.invoke (statemachine);
				return true;
				
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}else{
			System.err.println("initAndEnter failed because statemashine not set");
			return false;
		}
	}
	
	public boolean runCycle(){
		if (this.statemachine != null) {
			try {
				Method runCycle = statemachineClass.getDeclaredMethod("runCycle", new Class[]{});
				runCycle.invoke (statemachine);
				return true;
				
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}else{
			System.err.println("runCycle failed because statemashine not set");
			return false;
		}
	}
}
