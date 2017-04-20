package modules.parser;

import java.io.Serializable;
import java.util.Vector;

import main.Start;

public class ObjectDet implements IParser, Serializable {
	private static final long serialVersionUID = 1L;
	private Start start;
	
	private Vector<Objects.object> objList = new Vector<Objects.object>();
	private boolean objDetected;

	public boolean parse(String data, Start start) {
		this.start = start;
		
		//TODO Muss getestet werden
		
		if (data.contains("OUTPUT#")) {
			try {
				String[] d = data.substring(7).split(";");
				
				String name = d[0];
				int xPos = Integer.parseInt(d[1]);
				int yPos = Integer.parseInt(d[2]);
				int width = Integer.parseInt(d[3]);
				int height = Integer.parseInt(d[4]);
				String path = d[5];
				int depth = Integer.parseInt(d[6]);
				this.objList.add(new Objects.object(name, xPos, yPos, width, height, path, depth));
				return true;
			} catch (NumberFormatException e) {
				System.err.println("ObjectDetection: Parsing int failed");
				e.printStackTrace();
				return false;
			}
		}else if(data.equals("FINISH")){
			this.setObjDetected(true);
			return true;
			
		}
		
		return false;
	}

	public boolean removeParsedInformation() {
		this.objList = new Vector<Objects.object>();
		this.objDetected = false;
		return true;
	}

	public boolean isObjDetected() {
		return objDetected;
	}

	public void setObjDetected(boolean objDetected) {
		this.objDetected = objDetected;
		
		if (objDetected) {
			//TODO implement raiseObjectDetected
		}
	}

	public Vector<Objects.object> getObjList() {
		return objList;
	}

	
}
