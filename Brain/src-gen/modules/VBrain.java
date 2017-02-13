package modules;

import org.yakindu.scr.brain.BrainStatemachine;

import modules.parser.Iparser;
import vBrain.*;
import main.*;

public class VBrain implements Iparser{

	@Override
	public boolean parse(String data, BrainStatemachine brain, Start start) {
		PersonList personList = start.getPersonList();
		if (data.contains("#STAT#")) {
			String dataStat = data.substring(6);
			System.out.println("Statische Daten: " + dataStat);
			String[] attributePartsVBS = dataStat.split(";");

			int faceId = Integer.parseInt(attributePartsVBS[0]);
			System.out.println("Face ID: " + faceId);

			if (personList.getCurrPerson() == null) {
				//Nur wenn Person noch nicht gesetzt wurde, dann machen
				if (personList.getPersonByFaceID(faceId) != null) {
					// Person already exists
					System.out.println("Person exists");
					personList.setCurrPersonByFaceID(faceId);
					
					personList.getCurrPerson().setGlasses((attributePartsVBS[4].contains("1")?true:false), brain);
				} else {

					Person p = new Person(personList.getUnusedPersonID(), brain, dataStat);
					//System.out.println(p.toString());
					personList.addPerson(p);
					System.out.println("Person ID: " + p.getPersonID());
					personList.setCurrPerson(p);
				}
			}else{
				personList.getCurrPerson().setGlasses((attributePartsVBS[4].contains("1")?true:false), brain);
			}
			
			brain.getSCIVBrain().setCountFoundFaces(1);
			

		} else if (data.contains("#DYN#")) {
			String dataDyn = data.substring(5);
			//System.out.println("Dynamische Daten: " + dataDyn);
			String[] attributePartsVBD = dataDyn.split(";");

			if (attributePartsVBD[0].contains("1")) {
				//System.out.println("Face found");


				if(attributePartsVBD.length > 1){
					//Gesicht hat schon eine FaceID von VBRain bekommen --> nach 5 Frames
					int faceId = Integer.parseInt(attributePartsVBD[1]);
					System.out.println("Face ID: " + faceId);
					Person p = personList.getPersonByFaceID(faceId);
					if (p != null) {
						//
						p.addDynData(dataDyn, brain);
						//System.out.println(p.getCurrDynData().toString());
					}
					//personList.setCurrPersonByFaceID(faceId);
					//brain.getSCIVBrain().setCountFoundFaces(1);
				}else{
					//noch keine FaceID, weil noch vor 5 Frames
					//System.out.println("No face ID");
					//personList.setCurrPerson(null);
					brain.getSCIVBrain().setCountFoundFaces(0); //Das muss wieder raus, wenn Leonie sofort stoppen soll bei erkannter Persom
				}

			} else {
				brain.getSCIVBrain().setCountFoundFaces(0);
				// System.out.println(" no face");
			}
		} else if (data.contains("#EMOTION#")) {
			String dataEmo = data.substring(9);
			if(dataEmo.contains("[")){
				dataEmo = dataEmo.substring(1, 2);
			}
			// Emotion e;
			// e.fromInt(Integer.parseInt(vbrainbM.group(2)));

			System.out.println("Emotion: " + dataEmo);

			Person p = personList.getCurrPerson();
			if (p != null && p.getCurrDynData() != null) {
				p.getCurrDynData().setEmotion(Integer.parseInt(dataEmo), brain);
				System.out.println("Current Person has emotion: " + p.getCurrDynData().getEmotion());
				//System.out.println(p.toString());
			}
		}
		return true;
	}	

}
