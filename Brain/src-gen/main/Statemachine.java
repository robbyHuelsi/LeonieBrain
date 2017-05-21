package main;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.time.Duration;
import java.util.Date;
import java.util.Vector;

import org.yakindu.scr.ITimer;
import org.yakindu.scr.TimerService;
import org.yakindu.scr.braganca.BragancaStatemachine;

public class Statemachine {
	private Start start;
	
	private String statemachineName;
	private Object statemachine = null;
	private Class<?> statemachineClass = null;
	private Vector<Class<?>> opCallbackImplClasses = new Vector<Class<?>>();
	private Date dateStarted;
	private String currState;
	private int statesCount;
	private boolean running;
	
	public Statemachine(Start start) {
		this("", start);
	}
	
	public Statemachine(String statemachineName, Start start) {
		this.start = start;
		
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
			for (Method m : statemachineClass.getDeclaredMethods()) {
				//System.out.println(m.getName());
				if (m.getName().equals("setTimer")) {
					Method setTime = statemachineClass.getDeclaredMethod("setTimer", new Class[] { ITimer.class });
					setTime.invoke(statemachine, new TimerService());
					break;
				}
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	public boolean setOperationCallbacks(){		
		if (this.statemachine != null) {

			Vector<String> opCallbackImplNames = new Vector<String>();
			
			// Get used SCI's from statemachine
			Method[] methods = statemachineClass.getDeclaredMethods();
			for (Method method : methods) {
				if (method.getName().startsWith("getSCI")) {
					opCallbackImplNames.add(method.getName().substring(6));
				}
			}
			System.out.println("opCallbackImplNames for " + this.statemachineName + ": " + opCallbackImplNames.toString());
						
			for (String opCallbackImplName : opCallbackImplNames) {
				try {
					Method getSCI = this.statemachineClass.getDeclaredMethod("getSCI" + opCallbackImplName, new Class[]{});
					Object sci = getSCI.invoke(this.statemachine);
					Class<?> sciClass = sci.getClass();
					Class<?> sciOperationCallback = Class.forName("org.yakindu.scr." + this.statemachineName.toLowerCase() + ".I" + this.statemachineName + "Statemachine$SCI" + opCallbackImplName + "OperationCallback");
					Class<?> opCallbackImplClass = Class.forName("callbacks.OpCallbackImpl" + opCallbackImplName);
					this.opCallbackImplClasses.add(opCallbackImplClass);
					Method setSCIOperationCallback = sciClass.getDeclaredMethod("setSCI" + opCallbackImplName + "OperationCallback", new Class[]{sciOperationCallback});
					Object opCallback = setSCIOperationCallback.invoke(sci, opCallbackImplClass.newInstance());
					
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
					return false;
				} catch (SecurityException e) {
					e.printStackTrace();
					return false;
				} catch (IllegalAccessException e) {
					e.printStackTrace();
					return false;
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
					return false;
				} catch (InvocationTargetException e) {
					e.printStackTrace();
					return false;
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
					return false;
				} catch (InstantiationException e) {
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
	
	public boolean sendInitToAllModules(boolean send) {
		if (send) {
			for (Class<?> opCallbackImplClass : this.opCallbackImplClasses) {
				try {
					Method sendInit = opCallbackImplClass.getDeclaredMethod("sendInit", new Class[]{});
					sendInit.invoke(opCallbackImplClass.newInstance());
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
					return false;
				} catch (SecurityException e) {
					e.printStackTrace();
					return false;
				} catch (IllegalAccessException e) {
					e.printStackTrace();
					return false;
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
					return false;
				} catch (InvocationTargetException e) {
					e.printStackTrace();
					return false;
				} catch (InstantiationException e) {
					e.printStackTrace();
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean initAndEnter(){
		if (this.statemachine != null) {
			try {
				Method init = statemachineClass.getDeclaredMethod("init", new Class[]{});
				Method enter = statemachineClass.getDeclaredMethod("enter", new Class[]{});
				init.invoke(statemachine);
				enter.invoke(statemachine);
				dateStarted = new Date();
				running = true;
				
				start.getGui().updateUI();
				
				return true;
				
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
				return false;
			} catch (SecurityException e) {
				e.printStackTrace();
				return false;
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				return false;
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				return false;
			} catch (InvocationTargetException e) {
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
				runCycle.invoke(statemachine);
				
				try {
					start.getGui().updateUI();
				} catch (Exception e) {
					System.err.println("Problem with runCycle()");
				}
				
				return true;
				
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
				return false;
			} catch (SecurityException e) {
				e.printStackTrace();
				return false;
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				return false;
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				return false;
			} catch (InvocationTargetException e) {
				e.printStackTrace();
				return false;
			}
		}else{
			System.err.println("runCycle failed because statemashine not set");
			return false;
		}
	}
	
	public boolean raiseEventOfSCI(String sciName, String eventName){
		if (sciName == null || sciName.isEmpty()) {
			System.err.println("raiseEventOfSCI failed bacause sciName is empty");
			return false;
		}
		
		if (eventName == null || eventName.isEmpty()) {
			System.err.println("raiseEventOfSCI failed bacause eventName is empty");
			return false;
		}
		
		if (this.statemachine != null) {
			try {
				Method getSCI = statemachineClass.getDeclaredMethod("getSCI" + sciName, new Class[]{});
				Object sci = getSCI.invoke(this.statemachine);
				Class<?> sciClass = sci.getClass();
				String raiseMethodName = "raise" + eventName.substring(0, 1).toUpperCase() + eventName.substring(1);
				Method raise = sciClass.getDeclaredMethod(raiseMethodName, new Class[]{});
				raise.invoke(sci);	
				
				return true;
				
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
				return false;
			} catch (SecurityException e) {
				e.printStackTrace();
				return false;
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				return false;
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				return false;
			} catch (InvocationTargetException e) {
				e.printStackTrace();
				return false;
			}
		}else{
			System.err.println("getSCI failed because statemashine not set");
			return false;
		}
	}
	
	public Object getVaribaleOfSCI(String sciName, String varName){
		if (sciName == null || sciName.isEmpty()) {
			System.err.println("getVaribaleOfSCI failed bacause sciName is empty");
			return null;
		}
		
		if (varName == null || varName.isEmpty()) {
			System.err.println("getVaribaleOfSCI failed bacause varName is empty");
			return null;
		}
		
		if (this.statemachine != null) {
			try {
				Method getSCI = statemachineClass.getDeclaredMethod("getSCI" + sciName, new Class[]{});
				Object sci = getSCI.invoke(this.statemachine);
				Class<?> sciClass = sci.getClass();
				String getName = "get" + varName.substring(0, 1).toUpperCase() + varName.substring(1);
				Method get = sciClass.getDeclaredMethod(getName, new Class[]{});
				return get.invoke(sci);
				
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
				return null;
			} catch (SecurityException e) {
				e.printStackTrace();
				return null;
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				return null;
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
				return null;
			} catch (InvocationTargetException e) {
				e.printStackTrace();
				return null;
			}
		}else{
			System.err.println("getVaribaleOfSCI failed because statemashine not set");
			return null;
		}
	}

	public String getName(){
		return statemachineName;
	}
	
	public String getDurationString(){
		if (dateStarted == null) {
			return "";
		}else{			
			long diff = (new Date()).getTime() - this.dateStarted.getTime();
			
			int hours = (int) (diff / (60 * 60 * 1000));
			int minutes = (int) (diff - hours * 60 * 60 * 1000) / (60 * 1000);
			int seconds = (int) (diff - minutes * 60 * 1000) / 1000;      
			
			return (hours < 9?"0":"") + hours + ":" + (minutes < 9?"0":"") + minutes + ":" + (seconds < 9?"0":"") + seconds;
		}
	}
	
	public String getCurrState(){
		if (this.statesCount == 0) {
			setStatesCount();
		}
		
		/*if (this.statesCount != 0) {
			try {
				//Method isStateActive = statemachineClass.getDeclaredMethod("isStateActive", new Class[]{int.class});
				for (Method m : statemachineClass.getDeclaredMethods()) {
					if (m.getName().equals("isStateActive")) {
						System.out.println(m.getName());
						int i = 1;
						Object sci = m.invoke(this.statemachine, i);
					}
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			//} catch (NoSuchMethodException e) {
				//e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			}
		}*/
		
		return "x of " + (this.statesCount==0?"?":this.statesCount);
	}
	
	private boolean setStatesCount(){
		//get stateCounts()
		Field fieldState[] = statemachine.getClass().getDeclaredFields();
		for (Field field : fieldState) {
			if (field.getName().contains("$State")) {
				field.setAccessible(true);

				try {
					int[] states = (int[]) field.get(statemachine);
					this.statesCount = states.length;
					//System.out.println(states.length);
					return true;
				} catch (IllegalArgumentException e) {
					//e.printStackTrace();
					return false;
				} catch (IllegalAccessException e) {
					//e.printStackTrace();
					return false;
				}
			}
		}
		return false;
	}

	public boolean isRunning() {
		return running;
	}
	
}
