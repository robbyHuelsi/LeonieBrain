package modules.parser;

public class PersonCrowd {

	private int gender;
	private int age;
	private int position;
	private String color;
	private int waving;
	

	public PersonCrowd(int gender, int age, int position, String colour, int waving) {
		setGender(gender);
		setAge(age);
		setPosition(position);
		setColor(colour);
		setWaving(waving);
	}
	
	

	public void setGender(int gender) {
		this.gender = gender;
	}
	
	public int getGender() {
		return gender;
	}


	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	
	public void setPosition(int position) {
		this.position = position;
	}

	public int getPosition() {
		return position;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}



	public int getWaving() {
		return waving;
	}

	public void setWaving(int waving) {
		this.waving = waving;
	}


}
