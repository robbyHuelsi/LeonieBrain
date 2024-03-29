package modules.parser;

import java.io.Serializable;

import Persons.*;
import main.*;
import modules.Module;

public class VBrain implements IParser, Serializable{
	private static final long serialVersionUID = 1L;
	private Start start;
	
	// Parsed information
	private int countFoundFaces;
	private boolean nessesaryToSavePersonList;

	public boolean parse(String data, Start start) {
		this.start = start;
		
		PersonList personList = start.getPersonList();
		if (data.contains("#STAT#")) {
			String dataStat = data.substring(6);
			start.getLog().log("Statische Daten: " + dataStat);
			String[] attributePartsVBS = dataStat.split(";");

			int faceId = Integer.parseInt(attributePartsVBS[0]);
			start.getLog().log("Face ID: " + faceId);

			if (personList.getCurrPerson() == null) {
				//Nur wenn Person noch nicht gesetzt wurde, dann machen
				if (personList.getPersonByFaceID(faceId) != null) {
					// Person already exists
					start.getLog().log("Person exists");
					personList.setCurrPersonByFaceID(faceId, start);
					
					personList.getCurrPerson().setGlasses((attributePartsVBS[4].contains("1")?true:false), start);
				} else {

					Person p = new Person(personList.getUnusedPersonID(), start, dataStat);
					//start.getLog().log(p.toString());
					personList.addPerson(p, start);
					start.getLog().log("Person ID: " + p.getPersonID());
					personList.setCurrPerson(p, start);
				}
			}else{
				personList.getCurrPerson().setGlasses((attributePartsVBS[4].contains("1")?true:false), start);
			}
			
			this.setCountFoundFaces(1);
			

		} else if (data.contains("#DYN#")) {
			String dataDyn = data.substring(5);
			//start.getLog().log("Dynamische Daten: " + dataDyn);
			String[] attributePartsVBD = dataDyn.split(";");

			if (attributePartsVBD[0].contains("1")) {
				//start.getLog().log("Face found");


				if(attributePartsVBD.length > 1){
					//Gesicht hat schon eine FaceID von VBRain bekommen --> nach 5 Frames
					int faceId = Integer.parseInt(attributePartsVBD[1]);
					start.getLog().log("Face ID: " + faceId);
					Person p = personList.getPersonByFaceID(faceId);
					if (p != null) {
						//
						p.addDynData(dataDyn, start);
						//start.getLog().log(p.getCurrDynData().toString());
					}
					//personList.setCurrPersonByFaceID(faceId);
					//brain.getSCIVBrain().setCountFoundFaces(1);
				}else{
					//noch keine FaceID, weil noch vor 5 Frames
					//start.getLog().log("No face ID");
					//personList.setCurrPerson(null);
					this.setCountFoundFaces(0); //Das muss wieder raus, wenn Leonie sofort stoppen soll bei erkannter Persom
				}

			} else {
				this.setCountFoundFaces(0);
				// start.getLog().log(" no face");
			}
		} else if (data.contains("#EMOTION#")) {
			String dataEmo = data.substring(9);
			if(dataEmo.contains("[")){
				dataEmo = dataEmo.substring(1, 2);
			}
			// Emotion e;
			// e.fromInt(Integer.parseInt(vbrainbM.group(2)));

			start.getLog().log("Emotion: " + dataEmo);

			Person p = personList.getCurrPerson();
			if (p != null && p.getCurrDynData() != null) {
				p.getCurrDynData().setEmotion(Integer.parseInt(dataEmo), start);
				start.getLog().log("Current Person has emotion: " + p.getCurrDynData().getEmotion());
				//start.getLog().log(p.toString());
			}
		}
		return true;
	}

	public int getCountFoundFaces() {
		return countFoundFaces;
	}

	public void setCountFoundFaces(int countFoundFaces) {
		this.countFoundFaces = countFoundFaces;
	}

	public boolean isNessesaryToSavePersonList() {
		return nessesaryToSavePersonList;
	}

	public void setNessesaryToSavePersonList(boolean nessesaryToSavePersonList) {
		this.nessesaryToSavePersonList = nessesaryToSavePersonList;
	}

	public boolean removeParsedInformation() {
		this.countFoundFaces = -1;
		this.nessesaryToSavePersonList = false;
		
		return true;
	}	
}
