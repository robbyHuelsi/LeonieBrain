package modules.parser;

public class PersonCrowd {

	private int gender;
	private int age;
	private int position;
	
	public PersonCrowd(int gender, int age, int position) {
		setGender(gender);
		setAge(age);
		setPosition(position);
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


}
