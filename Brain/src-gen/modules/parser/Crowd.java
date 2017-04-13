package modules.parser;

import java.io.Serializable;

import main.Start;
import modules.Module;

public class Crowd implements IParser, Serializable{
	private static final long serialVersionUID = 1L;
	private Start start;
	private int countTotal;
	private int countFemale;
	private int countMale;
	private int countUnder21;

	@Override
	public boolean parse(String data, Start start) {
		/*	#sender#total#gender1;age1+gender2;age2+ etc. #
			sendername: “crowd”
			total: Gesamtanzahl
			gender: 0=male ; 1=female
		 */
		
		this.start = start;
		
		String[] crowd = data.split("#");
		
		if (crowd[0]!=null) {
			this.setCountTotal(Integer.parseInt(crowd[0]));
			
			String[] people = crowd[1].split("+");
			String[] genderAndAge = null;
			for(int counter=1; counter<=this.getCountTotal(); counter++){
				genderAndAge = people[counter].split(";");
			}
			
			if(genderAndAge!=null){
				for(int count=0; count<=genderAndAge.length; count++){
					//gender
					if(count%2 == 0){
						if(genderAndAge[count]=="0"){
							this.setCountMale(this.getCountMale() + 1);
						}else if(genderAndAge[count]=="1"){
							this.setCountFemale(this.getCountFemale() + 1);
						}
					//age	
					}else if(count%2 != 0){
						int age = Integer.parseInt(genderAndAge[count]);
						
					}
				}
			}
			
		} else if(data.contains("0")){
			/*brain.getSCIHBrain().setTTSReady(true);*/ //TODO: Sarah: Warum????
			//System.out.println("TTS ready");
		}

		return true;
	}

	
	
	public int getCountTotal() {
		return countTotal;
	}

	public void setCountTotal(int countTotal) {
		this.countTotal = countTotal;
	}

	public int getCountFemale() {
		return countFemale;
	}

	public void setCountFemale(int countFemale) {
		this.countFemale = countFemale;
	}

	public int getCountMale() {
		return countMale;
	}

	public void setCountMale(int countMale) {
		this.countMale = countMale;
	}

	public int getCountUnder21() {
		return countUnder21;
	}

	public void setCountUnder21(int countUnder21) {
		this.countUnder21 = countUnder21;
	}

}
