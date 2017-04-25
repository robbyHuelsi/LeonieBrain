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
		
		//TODO Muss getestet werden
		
		if (data.contains("OUTPUT#")) {
			String[] d = data.substring(7).split(";");	
			try {
				String name = d[0];
				int xPos = Integer.parseInt(d[1]);
				int yPos = Integer.parseInt(d[2]);
				int width = Integer.parseInt(d[3]);
				int height = Integer.parseInt(d[4]);
				this.objList.add(new Objects.object(name, xPos, yPos, width, height));
			} catch (NumberFormatException e) {
				System.err.println("ObjectDetection: Parsing int failed");
				e.printStackTrace();
			}
			return true;
		}else if(data.equals("DONE")){
			this.setAnalyseDone(true);
			return true;
			
		}else if(data.equals("RESPONSE#READY")){
			this.setReady(true);
			return true;
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

	public String getSummaryText() {
		if (this.objList.isEmpty()) {
			return "[:-(] I didn't found objects.";
		}else{
			String sum = "[:-)] I found " + this.objList.size() + " objects!";
			Vector<Objects.object> ol = this.objList;
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
