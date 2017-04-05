package modules.parser;

import java.io.Serializable;

import org.yakindu.scr.brain.BrainStatemachine;

import main.Start;

public class Crowd implements IParser, Serializable{

	@Override
	public boolean parse(String data, BrainStatemachine brain, Start start) {
		/*	#sender#total#gender1;age1+gender2;age2+ etc. #
			sendername: “crowd”
			total: Gesamtanzahl
			gender: 0=male ; 1=female
		 */
		String[] genderAndAge = null;
		int female=0;
		int male=0;
		int under21;
		String[] crowd = data.split("#");
		if (crowd[0]!=null) {
			int total = Integer.parseInt(crowd[0]);
			String[] people = crowd[1].split("+");
			for(int counter=1; counter<=total; counter++){
				genderAndAge = people[counter].split(";");
			}
			if(genderAndAge!=null){
				for(int count=0; count<=genderAndAge.length; count++){
					//gender
					if(count%2 == 0){
						if(genderAndAge[count]=="0"){
							male+=1;
						}else if(genderAndAge[count]=="1"){
							female+=1;
						}
					//age	
					}else if(count%2 != 0){
						int age = Integer.parseInt(genderAndAge[count]);
						
					}
				}
			}
			
		} else if(data.contains("0")){
			brain.getSCIHBrain().setTTSReady(true);
			//System.out.println("TTS ready");
		}

		return true;
	}

}
