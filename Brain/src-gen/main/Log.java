package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Log {
	private String savingsFolderPath;
	private String smName;
	private Date dateStarted;
	private PrintWriter writer;

	public Log(String savingsFolderPath){
		this.savingsFolderPath = savingsFolderPath;
	}
	
	protected void finalize(){
	   this.endSM();
	}
	
	public boolean startSM(String smName){
		this.smName = smName;
		this.dateStarted = new Date();
		
		if (writer != null) {
			writer.close();
		}
		
		try {
			File f = new File(this.savingsFolderPath + "Log" + System.getProperty("file.separator") + this.getDateTimeString("yyyy-MM-dd_HH-mm-ss") + "_" + this.smName + ".txt");
			f.getParentFile().mkdirs();
			this.writer = new PrintWriter(f, "UTF-8");
			this.writeHeader();
			return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public void endSM(){
		this.smName = null;
		
		if (writer != null) {
			this.writeFooter();
			writer.close();
			writer = null;
		}
	}
	
	public void log(String s){
		s = this.getDateTimeString("HH:mm:ss") + ": " + s;
		System.out.println((writer==null?"(!) ":"") + s); //Wenn nicht in ein Log-File geschrieben wird, dann zeige "(!)"
		this.writeToFile(s);
	}
	
	public void log(boolean s){
		log(s?"true":"false");
	}
	
	public void error(String e){
		e = this.getDateTimeString("HH:mm:ss") + ": " + e;
		System.err.println((writer==null?"(!) ":"") + e); //Wenn nicht in ein Log-File geschrieben wird, dann zeige "(!)"
		this.writeToFile(e);
	}
	

	
	private boolean writeToFile(String s){
		if (writer != null) {
			writer.println(s);
			writer.flush();
			return true;
		}else{
			return false;
		}
	}
	
	private boolean writeHeader(){
		if (writer != null) {
			writer.println("Date:\t\t" + this.getDateTimeString("EEEE, dd. MMMM yyyy"));
			writer.println("Time:\t\t" + this.getDateTimeString("HH:mm:ss (zzzz)"));
			writer.println("Statemachine:\t" + this.smName);
			writer.println("Team:\t\tRT-Lions");
			writer.println();
			writer.println("-------------------- Start --------------------");
			writer.println();
			writer.flush();
			return true;
		}else{
			return false;
		}
	}
	
	private boolean writeFooter(){
		if (writer != null) {
			writer.println();
			writer.println("--------------------  End  --------------------");
			writer.println();
			writer.flush();
			writer.println("Duration:\t" + getDurationString());
			writer.flush();
			return true;
		}else{
			return false;
		}
	}
	
	
	
	private String getDateTimeString(String pattern){
		return new SimpleDateFormat(pattern).format(Calendar.getInstance().getTime());
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

}
