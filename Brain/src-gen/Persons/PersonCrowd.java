package Persons;

import java.io.Serializable;

public class PersonCrowd implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int gender;
	private int age;
	private int position;
	private int color;
	private int waving;
	

//	-1: not detectable
//	0: black [0, 0, 0]
//	1: white [255, 255, 255]
//	2: red [255, 0, 0]
//	3: yellow [255, 255, 255]
//	4: green [0, 255, 0]
//	5: blue [0, 0, 255]

	public PersonCrowd(int gender, int age, int position) {
		setGender(gender);
		setAge(age);
		setPosition(position);
		setColor(-1);
		setWaving(-1);
	}
	
	public PersonCrowd(int gender, int age, int position, int color, int waving) {
		setGender(gender);
		setAge(age);
		setPosition(position);
		setColor(color);
		setWaving(waving);
	}
	
	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getWaving() {
		return waving;
	}

	public void setWaving(int waving) {
		this.waving = waving;
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
