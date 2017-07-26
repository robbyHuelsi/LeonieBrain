package modules.parser;

import java.io.Serializable;
import java.io.ObjectInputStream.GetField;
import java.util.Vector;
import java.util.regex.Pattern;

import Persons.PersonCrowd;
import Persons.PersonList;
import communication.MessageParser;
import main.Log;
import main.Start;
import modules.Module;
import modules.Modules;

public class CrowdDet implements IParser, Serializable{
	private static final long serialVersionUID = 1L;
	private Start start;
		
	private Vector<PersonCrowd> personList = new Vector<PersonCrowd>();
	private boolean crowdDetected;


	public boolean parse(String data, Start start) {
		/* 
		 * data: [totalCount:int]#[gender1:int],[age1:int],[position1:int],[shirtcolor1:int],[waving1:int],[angle1:int],[distance1:float];[position2:int],[gender2:int],[age2:int], etc. #
		 * gender: -1=not detectable; 0=male ; 1=female
		 * age: -1=not detectable
		 * position: 0=standing; 1=sitting; 2=lying
		 */ 

		this.start = start;
		
		this.personList.removeAllElements();
		if (!data.equals("0#")) {
			String[] datas = data.split("#");
			String[] crowd = datas[1].split(";"); //crowd: 1 person per indices
				
			for(int i = 0; i < crowd.length; i++){
				String[] person = crowd[i].split(",");
				try {
					start.getLog().log(crowd[i]);
					int gender = Integer.parseInt(person[0]);
					int age = Integer.parseInt(person[1]);
					int position = Integer.parseInt(person[2]);
					int color=Integer.parseInt(person[3]);
					int waving = Integer.parseInt(person[4]);
					int angle = Integer.parseInt(person[5]);
					float distance = Integer.parseInt(person[6]);
					personList.add(new PersonCrowd(gender, age, position,color,waving, angle, distance));
					
				} catch (Exception e) {
					start.getLog().error("CrowdDet: Parsing string to int failed");
				}
			}
			int total = Integer.parseInt(datas[0]); //datas[0] = total count 
			if (total == personList.size()) {
				if (total > 0) {
					// Hier sollte das Programm eingentlich nie reingehen...
					this.setCrowdDetected(true);
				}
				return true;
			}else{
				start.getLog().log("There is not the same number of Persons in personList (" + personList.size() + ") like total count (" + total + ")");
				return false;
			}
		}else{
			return true; //no person
		}
	}
	

	public boolean isCrowdDetected() {
		return crowdDetected;
	}

	/* 
	 * sets transition in statemachine
	 */	
	public void setCrowdDetected(boolean crowdDetected) {
		this.crowdDetected = crowdDetected;
		if (crowdDetected) {
			start.getStatemachine().raiseEventOfSCI("CrowdDetection","detected");
		}
	}


	public boolean areAllGendersDetected() {
		Vector<PersonCrowd> pl = this.personList; //Es kann sein, dass von einem anderen Thread der Vector geupdatet wird.
		for (PersonCrowd p : pl) {
			if (p.getGender() == -1) {
				return false;
			}
		}
		return true;
	}


	public boolean areAllAgesDetected() {
		Vector<PersonCrowd> pl = this.personList; //Es kann sein, dass von einem anderen Thread der Vector geupdatet wird.
		for (PersonCrowd p : pl) {
			if (p.getAge() == -1) {
				return false;
			}
		}
		return true;
	}
	
	public int getTotalCount() {
		return this.personList.size();
	}
	
	public int getSpecificCount(long gender, long minAge, long maxAge, long position, long color, long waving){
		Vector<Integer> vGender = new Vector<Integer>();
		Vector<Integer> vMinAge = new Vector<Integer>();
		Vector<Integer> vMaxAge = new Vector<Integer>();
		Vector<Integer> vPosition = new Vector<Integer>();
		Vector<Integer> vColor = new Vector<Integer>();
		Vector<Integer> vWaving = new Vector<Integer>();
		
		vGender.add((int)gender);
		vMinAge.add((int)minAge);
		vMaxAge.add((int)maxAge);
		vPosition.add((int)position);
		vColor.add((int)color);
		vWaving.add((int)waving);
		
		return getSpecificCount(vGender, vMinAge, vMaxAge, vPosition, vColor, vWaving);
	}
	
	/*
	 * returns the number of people matching the input conditions
	 * count = getSpecificCount(-1,-1,-1,-1,-1,1);
	 */
	public int getSpecificCount(Vector<Integer> gender, Vector<Integer> minAge, Vector<Integer> maxAge, Vector<Integer> position, Vector<Integer> color, Vector<Integer> waving){
		Vector<PersonCrowd> pl = new Vector<PersonCrowd>(this.personList);
		start.getLog().log("Get Specific Count: " + "gender = " + genderString(gender) + "; minAge = " + minAge + "; maxAge = " + maxAge + "; position = " + posString(position) + "; color = " + colorString(color) + "; waving = " + wavingString(waving));
		//System.out.println("TestTest: " + this.personList.toString());
		int removeCounter = 0;
		for (int i = 0; i < pl.size(); i++) {
			removeCounter = 0;

			//gender: -1 = not detectable; 0 = male ; 1 = female
			if (gender.get(0) != -1 && pl.get(i).getGender() != gender.get(0)) {
				start.getLog().log("Person (Gender: " + pl.get(i).getGender() + ") removed, because gender doesn't fit. (Required: " + genderString(gender) + ")");
				pl.remove(i);
				removeCounter++;
				
			//age: -1 = not detectable
			}else if(minAge.get(0) != -1 && pl.get(i).getAge() < minAge.get(0) ){
				start.getLog().log("Person (Age: " + pl.get(i).getAge() + ") removed, because too young. (Required minimum: " + minAge + ")");
				pl.remove(i);
				removeCounter++;
			}else if(maxAge.get(0) != -1 && pl.get(i).getAge() > maxAge.get(0)){
				start.getLog().log("Person (Age: " + pl.get(i).getAge() + ") removed, because too old. (Required maximum: " + maxAge + ")");
				pl.remove(i);
				removeCounter++;
				
			//position: 0 = stehen; 1 = sitzen; 2 = liegen
			}else if(position.get(0) != -1 && pl.get(i).getPosition() != position.get(0)){
				start.getLog().log("Person (Position: " + pl.get(i).getPosition() + ") removed, because position doesn't fit. (Required: " + posString(position) + ")");
				pl.remove(i);
				removeCounter++;
			
			//waving
			}else if(waving.get(0) != -1 && pl.get(i).getWaving() != waving.get(0)){
				start.getLog().log("Person (Waving: " + pl.get(i).getWaving() + ") removed, because waving doesn't fit. (Required: " + wavingString(waving) + ")");
				pl.remove(i);
				removeCounter++;
			
			//color 0 = black [0, 0, 0]; 1 = white [255, 255, 255]; 2 = red [255, 0, 0]; 3 = yellow [255, 255, 255]; 4 = green [0, 255, 0]; 5 = blue [0, 0, 255]
			}else if(color.get(0) != -1 && pl.get(i).getColor() != color.get(0)){
				start.getLog().log("Person (T-Shirt Color: " + pl.get(i).getColor() + ") removed, because color doesn't fit. (Required: " + colorString(color) + ")");
				pl.remove(i);
				removeCounter++;
			}
			
			//TODO every combination... 
			/*
			 * gender, minAge, maxAge, position, color, waving
			 */
			i -= removeCounter;
		}
		return pl.size();
	}


	public boolean removeParsedInformation() {
		this.personList.removeAllElements();
		this.crowdDetected = false;
		return true;
	}
	
	/*
	 * returns a string with detailed information about the people in the crowd
	 */
	public String getSummaryString(){
	//no person detected
		if (this.personList.isEmpty()) {
			return "[:-(] I didn't find some people.";
		}else{
			String sum;
	//one person detected	
			if (this.personList.size() == 1) {
				sum = "[:-)] I found one person!";
				//GENDER
				if (this.personList.get(0).getGender() == 0) {
					sum += " He is male.";
				}else if (this.personList.get(0).getGender() == 1){
					sum += " She is female.";
				}else{
					sum += " I'm not sure what the gender of this person is.";
				}
				//AGE
				if (this.personList.get(0).getAge() == -1) {
					sum += " I was not able to get the age.";
				}else{
					sum += " I think the person is approximately" + this.personList.get(0).getAge() + " years old.";
				}
				//POSITION
				if (this.personList.get(0).getPosition() == 0) {
					sum += " The person is standing.";
				}else if (this.personList.get(0).getPosition() == 1){
					sum += " The person is sitting.";
				}else if(this.personList.get(0).getPosition() == 2){
					sum += " The person is lying.";
				}
				
				//WAVING
				if (this.personList.get(0).getWaving() == 1) {
					sum += " The person is waving.";
				}
				
				//COLOR
				if (this.personList.get(0).getColor() == 5) {
						sum += " The person is wearing blue.";
				}else if(this.personList.get(0).getColor() == 4){
					sum += " The person is wearing green.";
				}else if(this.personList.get(0).getColor() == 2){
					sum += " The person is wearing red.";
				}else if(this.personList.get(0).getColor() == 3){
					sum += " The person is wearing yellow.";
				}else if(this.personList.get(0).getColor() == 1){
					sum += " The person is wearing white.";
				}else if(this.personList.get(0).getColor() == 0){
					sum += " The person is wearing black.";
				}
			//more than one person detected
			}else{
				sum = "[:-)] I found " + this.personList.size() + " persons!";
				
				int male = 0;
				int female = 0;
				int unknownGender = 0;
				int standing = 0;
				int sitting = 0;
				int lying = 0;
				//int unknownPos = 0;
				int young = 0;
				int middleAged = 0;
				int old = 0;
				int unknownAge = 0;
				int waving = 0;
//				-1: not detectable
//				0: black [0, 0, 0]
//				1: white [255, 255, 255]
//				2: red [255, 0, 0]
//				3: yellow [255, 255, 255]
//				4: green [0, 255, 0]
//				5: blue [0, 0, 255]

				int blue = 0;
				int green = 0;
				int red = 0;
				int yellow = 0;
				int white = 0;
				int black = 0;
				
				
				for (PersonCrowd person : personList) {
					if(person.getGender() == -1){unknownGender++;}
					if(person.getGender() == 0){male++;}
					if(person.getGender() == 1){female++;}
					
					if(person.getAge() == -1){unknownAge++;}
					if(person.getAge() > 0 && person.getAge() < 25){young++;}
					if(person.getAge() > 24 && person.getAge() < 55){middleAged++;}
					if(person.getAge() > 54){old++;}
					
					if(person.getPosition() == 0){standing++;}
					if(person.getPosition() == 1){sitting++;}
					if(person.getPosition() == 2){lying++;}
					
					if(person.getColor() == 5){blue++;}
					if(person.getColor() == 4){green++;}
					if(person.getColor() == 2){red++;}
					if(person.getColor() == 3){yellow++;}
					if(person.getColor() == 1){white++;}
					if(person.getColor() == 0){black++;}
				}
				//GENDER
				if (female == 1) {
						sum += " One person is female.";
				}else if (female > 1){
					sum += " " + female + " of them are female.";
				}
				if (male == 1) {
					sum += " One person is male.";
				}else if (male > 1){
					sum += " " + male + " of them are male.";
				}
				if (unknownGender == 1) {
					sum += " For one person I was not able to get the gender.";
				}else if (unknownGender > 1){
					sum += " For " + unknownGender + " persons I was not able to get the gender.";
				}
				
				//AGE
				if (young == 1) {
						sum += " One person is young.";
				}else if (young > 1){
					sum += " " + young + " of the people are young.";
				}
				if (middleAged == 1) {
					sum += " One person is middle aged.";
				}else if (middleAged > 1){
					sum += " " + middleAged + " of the people are middle aged.";
				}
				if (old == 1) {
					sum += " One person seems old.";
				}else if (old > 1){
					sum += " " + old + " of the people seem old.";
				}
				if (unknownAge == 1) {
					sum += " For one person I was not able to detect the age.";
				}else if (unknownAge > 1){
					sum += " For " + unknownAge + " persons I was not able to detect the age.";
				}
				
				//POSITION
				if (standing == 1) {
						sum += " One person is standing.";
				}else if (standing > 1){
					sum += " " + standing + " of the persons are standing.";
				}
				if (sitting == 1) {
					sum += " One person is sitting.";
				}else if (sitting > 1){
					sum += " " + sitting + " of the persons are sitting.";
				}
				if (lying == 1) {
					sum += " One person is lying.";
				}else if (lying > 1){
					sum += " " + lying + " of the persons are lying.";
				}
				
				//WAVING
				if (waving == 1) {
					sum += " One person is waving.";
				}else if (waving > 1){
					sum += " " + waving + " of the persons are waving.";
				}
				
				//COLOR
				if (blue == 1) {
					sum += " One person is wearing blue.";
				}else if (blue > 1){
					sum += " " + blue + " of the persons are wearing blue.";
				}
				if (green == 1) {
					sum += " One person is wearing green.";
				}else if (green > 1){
					sum += " " + green + " of the persons are wearing green.";
				}
				if (red == 1) {
					sum += " One person is wearing red.";
				}else if (red > 1){
					sum += " " + red + " of the persons are wearing red.";
				}
				if (yellow == 1) {
					sum += " One person is wearing yellow.";
				}else if (yellow > 1){
					sum += " " + yellow + " of the persons are wearing yellow.";
				}
				if (white == 1) {
					sum += " One person is wearing white.";
				}else if (white > 1){
					sum += " " + white + " of the persons are wearing white.";
				}
				if (black == 1) {
					sum += " One person is wearing black.";
				}else if (black > 1){
					sum += " " + black + " of the persons are wearing black.";
				}
			}
			return sum;
		}
	}

	//returns the angle from the closest person waving 
	public int getWavingAngle(){
		int angle = 100; //100 because we are searching for the person with the shortest distance to Leonie (Barman in restaurant)
		for (PersonCrowd person : personList) {
			if(person.getWaving()==1){
				if(Math.abs(person.getAngle()) < angle){
						angle = person.getAngle();

				}
			}
		}
		System.out.println("TEST angle: " + angle);
		return angle;
	}
	
	/* Counts the number of people in the crowd matching the inDetails 
	 * Example: inDetails = -1|-1|-1|4|-1
	 * gender |	position | minAge | maxAge | color | waving | angle | distance 
	 */
	public String getAnswerForSecificCrowdDetails(String inDetails) {
		String[] stringArgs = inDetails.split(Pattern.quote("|"));
		Vector<Vector<Integer>> arguments = new Vector<Vector<Integer>>();
		for (int i = 0; i < stringArgs.length; i++) {
			String stringTmp[] = stringArgs[i].split(Pattern.quote(","));
			Vector<Integer> intVecTmp= new Vector<Integer>();
			for(int j = 0; j < stringTmp.length; j++){
				intVecTmp.add(Integer.parseInt(stringTmp[j]));
			}
			arguments.add(intVecTmp);
		}
		
		//Get the number of people with this criterias
		int count = getSpecificCount(arguments.get(0),arguments.get(1),arguments.get(2),arguments.get(3), arguments.get(4), arguments.get(5));
		
		String msg = "I found ";
		
		if (count == 0) {
			msg += "no persons";
		}else if(count == 1){
			msg += "one person";
		}else{
			msg += + count + " person";
		}
						
		//COUNT ALL
		if(arguments.get(0).get(0)==-1 && arguments.get(1).get(0)==-1 && arguments.get(2).get(0)==-1 && arguments.get(3).get(0)==-1 && arguments.get(4).get(0)==-1 && arguments.get(5).get(0)==-1){
			//There are no specific criterias, so "count" is the number of all people in the crowed. Finish the sentence with a fullstop.
			msg += ".";
			
		}else{
			
			//fullfill the sentence with the criteria.
			msg += ", who ";
			if(count == 1){
				msg += "is ";
			}else{
				msg += "are ";
			}
		
			Vector<String> criteria = new Vector<String>();
			Vector<String> tmp = new Vector<String>();
			
			//GENDER
            tmp.clear();
            for (int i = 0; i < arguments.get(0).size(); i++) {
                //GENDER == MALE
                if(arguments.get(0).get(i) == 0){
                    tmp.add("male");
                }
                
                //GENDER == FEMALE
                if(arguments.get(0).get(i)==1){
                    tmp.add("female");
                }
            }
            
            if (tmp.size() == 1) {
                criteria.add(tmp.get(0));
            }else if(tmp.size() == 2){
                criteria.add(tmp.get(0) + " or " + tmp.get(1));
            }
            
            
            
            //AGE
            tmp.clear();
            
            //AGE == OLD (Min Age older than or eq 40)
            if(arguments.get(1).get(0) >= 40){
                tmp.add("old");
                criteria.add(tmp.get(0));
            }
            
            //AGE == MIDDLE (Min Age older than or eq 17 and Max Age younger than or eq 40)
            else if(arguments.get(1).get(0) >= 17 && arguments.get(2).get(0) <= 40){
                tmp.add("middle aged");
                criteria.add(tmp.get(0)); 
            }
            
            //AGE == YOUNG (Max Age smaller than or eq 17)
            else if(arguments.get(2).get(0) <= 17){
                tmp.add("young");
                criteria.add(tmp.get(0));
            }
            
            else{
            	tmp.add("older than " + arguments.get(2).get(0) + " and younger than " + arguments.get(3).get(0));
                criteria.add(tmp.get(0));
            }
            
          //POSITION
            tmp.clear();
            for (int i = 0; i < arguments.get(3).size(); i++) {
                //POSITION == STANDING
                if(arguments.get(3).get(i) == 0){
                    tmp.add("standing");
                }
                //POSITION == SITTING
                if(arguments.get(3).get(i)==1){
                    tmp.add("sitting");
                }
                //POSITION == LAYING
                if(arguments.get(3).get(i)==2){
                    tmp.add("laying");
                }
            }
            
            if (tmp.size() == 1) {
                criteria.add(tmp.get(0));
            }else if(tmp.size() == 2){
                criteria.add(tmp.get(0) + " or " + tmp.get(1));
            }else if(tmp.size() == 3){
                criteria.add(tmp.get(0) + ", " + tmp.get(1)+ " or " + tmp.get(2));
            }
            
            //COLOR
            tmp.clear();
            for (int i = 0; i < arguments.get(4).size(); i++) {
                //COLOR == 0 
                if(arguments.get(4).get(i) == 0){
                    tmp.add("black");
                }
                //COLOR == 1
                else if(arguments.get(4).get(i)==1){
                    tmp.add("white");
                }
                //COLOR == 2
                else if(arguments.get(4).get(i)==2){
                    tmp.add("red");
                }
                //COLOR == 3 
                else if(arguments.get(4).get(i) == 3){
                    tmp.add("yellow");
                }
                //COLOR == 4
                else if(arguments.get(4).get(i)==4){
                    tmp.add("green");
                }
                //COLOR == 5
                else if(arguments.get(4).get(i)==5){
                    tmp.add("blue");
                }
            }
            
            if (tmp.size() == 1) {
                criteria.add("wearing " + tmp.get(0));
            }else if(tmp.size() == 2){
                criteria.add("wearing " + tmp.get(0) + " or " + tmp.get(1));
            }else if(tmp.size() == 3){
                criteria.add("wearing " + tmp.get(0) + ", " + tmp.get(1) + " or " + tmp.get(2));
            }else if(tmp.size() == 4){
                criteria.add("wearing " + tmp.get(0) + ", " + tmp.get(1)+ ", " + tmp.get(2) + " or " + tmp.get(3));
            }else if(tmp.size() == 5){
                criteria.add("wearing " + tmp.get(0) + ", " + tmp.get(1) + ", " + tmp.get(2) + ", " + tmp.get(3) + " or " + tmp.get(4));
            }else if(tmp.size() == 6){
                criteria.add("wearing " + tmp.get(0) + ", " + tmp.get(1) + ", " + tmp.get(2) + ", " + tmp.get(3) + ", " + tmp.get(4) + " or " + tmp.get(5));
            }
            
            //WAVING
            tmp.clear();
            for (int i = 0; i < arguments.get(5).size(); i++) {
                //WAVING == TRUE
                if(arguments.get(5).get(i) == 0){
                    tmp.add("not waving");
                }else if(arguments.get(5).get(i) == 1){
                    tmp.add("waving");
                }
            }
            if (tmp.size() == 1) {
                criteria.add(tmp.get(0));
            }
            
           
            

            //summarize the text snippets to a full sentence
            for (int i = 0; i < criteria.size(); i++) {
                msg += criteria.get(i);
                
                if(i == criteria.size() - 2){
                    msg += " and ";
                    if(count == 1){
        				msg += "is ";
        			}else{
        				msg += "are ";
        			}
                }else if(i == criteria.size() - 1){
                    msg += ".";
                }else{
                    msg += ", ";
                }
            }
            
        }
        return msg;
    }
	

	//indicates the distance to the nearest person to Leonie
	public int getMinimalDistanceOfCrowd(){
		int distance = 100;
		System.out.println("personlist:   " + personList.toString());
		for(int persCounter=0; persCounter<personList.size(); persCounter++){
			System.out.println("LOOOOOP " + personList.get(persCounter).getDistance());
			if(distance>personList.get(persCounter).getDistance()){
				System.out.println("LOOOOOOOOP");
				distance = (int) personList.get(persCounter).getDistance();
			}
		}
		System.out.println("Distance: " + distance);
		return distance;
	}
	
	//gender: -1 = not detectable; 0 = male ; 1 = female
	private String genderString(Vector<Integer> gender){
		String msg = "[";
		for (Integer g : gender) {
			if (g == 0) {
				msg += "male, ";
			}else if (g == 1) {
				msg += "female, ";
			}else{
				msg += g + ", ";
			}
		}
		return msg.substring(0, msg.length() - 2) + "]";
	}
	
	//position: 0 = stehen; 1 = sitzen; 2 = liegen
	private String posString(Vector<Integer> position){
		String msg = "[";
		for (Integer p : position) {
			if (p == 0) {
				msg += "standing, ";
			}else if (p == 1) {
				msg += "sitting, ";
			}else if (p == 2) {
				msg += "laying, ";
			}else{
				msg += p + ", ";
			}
		}
		return msg.substring(0, msg.length() - 2) + "]";
	}
	
	//waving
	private String wavingString(Vector<Integer> waving){
		String msg = "[";
		for (Integer w : waving) {
			if (w == 0) {
				msg += "not waving, ";
			}else if (w == 1) {
				msg += "waving, ";
			}else{
				msg += w + ", ";
			}
		}
		return msg.substring(0, msg.length() - 2) + "]";
	}
			
	//color 0 = black [0, 0, 0]; 1 = white [255, 255, 255]; 2 = red [255, 0, 0]; 3 = yellow [255, 255, 255]; 4 = green [0, 255, 0]; 5 = blue [0, 0, 255]
	private String colorString(Vector<Integer> color){
		String msg = "[";
		for (Integer c : color) {
			if (c == 0) {
				msg += "black, ";
			}else if (c == 1) {
				msg += "white, ";
			}else if (c == 2) {
				msg += "red, ";
			}else if (c == 3) {
				msg += "yellow, ";
			}else if (c == 4) {
				msg += "green, ";
			}else if (c == 5) {
				msg += "blue, ";
			}else{
				msg += c + ", ";
			}
		}
		return msg.substring(0, msg.length() - 2) + "]";
	}
	
	public static void main(String[] args){
		
		Start t = Start.instanceOf();
		t.setModules(new Modules(t, t.getSavingsFolderPath()));
		t.setLog(new Log(t.getSavingsFolderPath()));
		t.setStatemachine("SpeechAndPersonRecognition", t);
		t.runStatemachine(t);
		MessageParser.ParseMessage("#CROWDDET#10#-1,-1,0,0,0,16,-1;0,4,0,0,0,29,211;0,4,0,5,0,24,189;1,2,0,3,0,3,64;1,4,0,2,0,-18,79;-1,-1,0,0,0,-3,-1;0,4,0,5,0,-41,111;-1,-1,0,5,0,34,-1;-1,-1,0,-1,0,19,-1;1,4,0,-1,0,41,113#");
		System.out.println(((CrowdDet)t.getModules().getParser("CrowdDet")).getAnswerForSecificCrowdDetails("1|-1|17|3|2,4|1"));

		System.out.println("end of test");
		
	}
	
}
