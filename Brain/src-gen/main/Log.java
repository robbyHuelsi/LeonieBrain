package main;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Log {
	private String smName;

	public Log(){
		
	}
	
	public void startSM(String name){
		this.smName = name;
	}
	
	public void endSM(){
		this.smName = null;
	}
	
	public void log(String s){
		System.out.println(getNow() + ": " + s);
	}
	
	public void log(boolean s){
		log(s?"true":"false");
	}
	
	public void error(String e){
		System.err.println(getNow() + ": " + e);
	}
	
	private String getNow(){
		return new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
	}
	
	private String getDateTime(){
		return new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());
	}
}
