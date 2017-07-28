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

import callbacks.OpCallbacksInUse;

public class Statemachine {
	private Start start;
	
	private String statemachineName;
	private Object statemachine = null;
	private Class<?> statemachineClass = null;
	private Vector<OpCallbacksInUse> opCallbacksInUse = new Vector<OpCallbacksInUse>();
	private Date dateStarted;
	private Date lastPing;
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
				start.getLog().error("Getting statemashine failed bacause statemachineName is empty");
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
				//start.getLog().log(m.getName());
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
			boolean failed = false;
			this.opCallbacksInUse.removeAllElements();
			start.getModules().resetAllOpCallbacks();
			
			// Get used SCI's from statemachine
			Method[] methods = statemachineClass.getDeclaredMethods();
			for (Method method : methods) {
				if (method.getName().startsWith("getSCI")) {
					this.opCallbacksInUse.add(new OpCallbacksInUse(method.getName().substring(6)));
				}
			}
			start.getLog().log("opCallbackImplNames for " + this.statemachineName + ": " + this.opCallbacksInUse.toString());
						
			for (OpCallbacksInUse opCallback : this.opCallbacksInUse) {
				try {
					Method getSCI = this.statemachineClass.getDeclaredMethod("getSCI" + opCallback.getName(), new Class[]{});
					Object sci = getSCI.invoke(this.statemachine);
					Class<?> sciClass = sci.getClass();
					Class<?> sciOperationCallback = Class.forName("org.yakindu.scr." + this.statemachineName.toLowerCase() + ".I" + this.statemachineName + "Statemachine$SCI" + opCallback.getName() + "OperationCallback");
					Class<?> opCallbackImplClass = Class.forName("callbacks.OpCallbackImpl" + opCallback.getName());
					
					opCallback.setOpCallbackImplClass(opCallbackImplClass);
					start.getModules().setOpCallbackId(opCallback.getName(), opCallback.getUid());
					start.getGui().updateTableModulesUI();
					
					Method setSCIOperationCallback = sciClass.getDeclaredMethod("setSCI" + opCallback.getName() + "OperationCallback", new Class[]{sciOperationCallback});
					setSCIOperationCallback.invoke(sci, opCallbackImplClass.newInstance());
					
				} catch (NoSuchMethodException e) {
					start.getLog().error(opCallback.getName() + ": " + e.getLocalizedMessage());
					opCallback.setException(e);
					failed = true;
				} catch (SecurityException e) {
					start.getLog().error(opCallback.getName() + ": " + e.getLocalizedMessage());
					opCallback.setException(e);
					failed = true;
				} catch (IllegalAccessException e) {
					start.getLog().error(opCallback.getName() + ": " + e.getLocalizedMessage());
					opCallback.setException(e);
					failed = true;
				} catch (IllegalArgumentException e) {
					start.getLog().error(opCallback.getName() + ": " + e.getLocalizedMessage());
					opCallback.setException(e);
					failed = true;
				} catch (InvocationTargetException e) {
					start.getLog().error(opCallback.getName() + ": " + e.getLocalizedMessage());
					opCallback.setException(e);
					failed = true;
				} catch (ClassNotFoundException e) {
					start.getLog().error(opCallback.getName() + ": " + e.getLocalizedMessage());
					opCallback.setException(e);
					failed = true;
				} catch (InstantiationException e) {
					start.getLog().error(opCallback.getName() + ": " + e.getLocalizedMessage());
					opCallback.setException(e);
					failed = true;
				}
			}

			if (failed) {
				return false;
			}else{
				return true;
			}
		}else{
			start.getLog().error("setOperationCallbacks failed because statemashine not set");
			return false;
		}
	}
	
//	public Vector<Class<?>> getOpCallbackImplClasses() {
//		return opCallbackImplClasses;
//	}
	
	public boolean sendPingToAllModules(){
		this.lastPing = new Date();
		
		for (OpCallbacksInUse opCallback : this.opCallbacksInUse) {
			try {
				if (opCallback.getClass() != null) {
					Method sendInit = opCallback.getOpCallbackImplClass().getDeclaredMethod("sendPing", new Class[]{});
					sendInit.invoke(opCallback.getOpCallbackImplClass().newInstance());
				}else{
					start.getLog().error("sendPingToAllModules() failed because " + opCallback.getName() + " has no getOpCallbackImplClass");
				}
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
		
		return true;
	}

	public Date getLastPing() {
		return lastPing;
	}

	public boolean sendInitToAllModules(boolean send) {
		if (send) {
			for (OpCallbacksInUse opCallback : this.opCallbacksInUse) {
				try {
					if (opCallback.getClass() != null) {
						Method sendInit = opCallback.getOpCallbackImplClass().getDeclaredMethod("sendInit", new Class[]{});
						sendInit.invoke(opCallback.getOpCallbackImplClass().newInstance());
					}else{
						start.getLog().error(opCallback.getName() + " has no getOpCallbackImplClass");
					}
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
				
				if(start.getGui() != null){ // For testing: if you want to run w/o GUI
					start.getGui().updateTableStateInfoUI();
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
			start.getLog().error("initAndEnter failed because statemashine not set");
			return false;
		}
	}
	
	public boolean runCycle(){
		if (this.statemachine != null) {
			try {
				Method runCycle = statemachineClass.getDeclaredMethod("runCycle", new Class[]{});
				runCycle.invoke(statemachine);
				
				try {
					start.getGui().updateTableStateInfoUI();
				} catch (Exception e) {
					start.getLog().error("Problem with runCycle()");
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
			start.getLog().error("runCycle failed because statemashine not set");
			return false;
		}
	}
	
	public boolean raiseEventOfSCI(String sciName, String eventName){
		if (sciName == null || sciName.isEmpty()) {
			start.getLog().error("raiseEventOfSCI failed bacause sciName is empty");
			return false;
		}
		
		if (eventName == null || eventName.isEmpty()) {
			start.getLog().error("raiseEventOfSCI failed bacause eventName is empty");
			return false;
		}
		
		if (this.statemachine == null) {
			start.getLog().error("raiseEventOfSCI failed because statemashine not set");
			return false;
		}
			
		if (this.running) {
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
			start.getLog().error("raiseEventOfSCI failed because statemashine not running");
			return false;
		}
	}
	
	public Object getVaribaleOfSCI(String sciName, String varName){
		if (sciName == null || sciName.isEmpty()) {
			start.getLog().error("getVaribaleOfSCI failed bacause sciName is empty");
			return null;
		}
		
		if (varName == null || varName.isEmpty()) {
			start.getLog().error("getVaribaleOfSCI failed bacause varName is empty");
			return null;
		}
		
		if (this.statemachine == null) {
			start.getLog().error("getVaribaleOfSCI failed because statemashine not set");
			return false;
		}
		
		if (this.running) {
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
			start.getLog().error("getVaribaleOfSCI failed because statemashine not running");
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
						start.getLog().log(m.getName());
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
					//start.getLog().log(states.length);
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
	
	public OpCallbacksInUse getOpCallbackInUseById(int id){
		if (id <= 0) {return null;}
		
		for (OpCallbacksInUse op : opCallbacksInUse) {
			if (op.getUid() == id) {
				return op;
			}
		}
		
		return null;
	}
	
	
	public boolean isModuleInUse(String name){
		for (OpCallbacksInUse op : opCallbacksInUse) {
			if (op.getName().equals(name)) {
				return true;
			}
		}
		
		return false;
	}
}
