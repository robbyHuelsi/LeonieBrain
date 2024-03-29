package modules.parser;

import java.io.Serializable;
import java.util.Vector;

import main.Start;

public class ObjectDet implements IParser, Serializable {
	private static final long serialVersionUID = 1L;
	private Start start;
	
	private Vector<Objects.object> objList = new Vector<Objects.object>();
	
	private boolean ready;
	private boolean analyseDone;
	public boolean parse(String data, Start start) {
		this.start = start;
				
		if (data.contains("OUTPUT#")) {
			String[] d = data.substring(7).split(";");	
			try {
				String name = d[0];
				int xPos = Integer.parseInt(d[1]);
				int yPos = Integer.parseInt(d[2]);
				int width = Integer.parseInt(d[3]);
				int height = Integer.parseInt(d[4]);
				this.objList.add(new Objects.object(name, xPos, yPos, width, height));
				start.getStatemachine().raiseEventOfSCI("ObjectDetection","objectDetected");
			} catch (NumberFormatException e) {
				start.getLog().error("ObjectDetection: Parsing int failed");
				e.printStackTrace();
			}
			return true;
		}else if(data.equals("DONE")){
			this.setAnalyseDone(true);
			return true;
			
		}else if(data.equals("RESPONSE#READY")){
			this.setReady(true);
			return true;
		}else if(data.contains("RESPONSE#PDF#")){
			
		}
		return false;
	}

	public boolean removeParsedInformation() {
		this.objList.removeAllElements();
		this.ready = false;
		this.analyseDone = false;
		return true;
	}

	public boolean isReady() {
		return ready;
	}

	public void setReady(boolean objDetected) {
		this.ready = objDetected;
		
		if (objDetected) {
			start.getStatemachine().raiseEventOfSCI("ObjectDetection","ready");
		}
	}

	public boolean isAnalyseDone() {
		return analyseDone;
	}

	public void setAnalyseDone(boolean analyseDone) {
		this.analyseDone = analyseDone;
		
		if (analyseDone) {
			start.getStatemachine().raiseEventOfSCI("ObjectDetection","analyseDone");
		}
	}
	
	public String getNewesObject() {
		if (!this.objList.isEmpty()) {
			return this.objList.lastElement().getName();
		}else{
			return "";
		}
	}

	public String getSummaryText() {
		if (this.objList.isEmpty()) {
			return "[:-(] I didn't found objects.";
		}else{
			String sum;
			
			if(this.objList.size() == 1){
				sum = "[:-)] I found one object!";
			}else{
				sum = "[:-)] I found " + this.objList.size() + " objects!";
			}
			
			Vector<Objects.object> ol = this.objList;
			
			//Get unknown objects
			int unknownCounter = 0;
			for (int i = 0; i < ol.size(); i++) {
				if (ol.get(i).getName().contains("Unknown")) {
					unknownCounter++;
					ol.remove(i);
					i--;
				}
			}
			
			if (this.objList.size() == 1 && unknownCounter == 1) {
				sum += " But this object is unknown [:-(]";
			}else if (this.objList.size() == unknownCounter) {
				sum += " But all objects are unknown [:-(]";
			}else if (unknownCounter == 1) {
				sum += " One of the objects is unknown.";
			}else if(unknownCounter > 1){
				sum += " I found " + unknownCounter + " unknown objects.";
			}
			
			//Get other objects
			while (!ol.isEmpty()) {
				String oName = ol.get(0).getName();
				int oCount = 0;
				for (int i = 0; i < ol.size(); i++) {
					if (ol.get(i).getName().equals(oName)) {
						oCount++;
						ol.remove(i);
						i--;
					}
				}
				if (oCount == 1) {
					sum += " There is one " + oName + ".";
				}else{
					sum += " There are " + oCount + " times of " + oName + ".";
				}
				
			}
			return sum;
		}
	}

	
}
