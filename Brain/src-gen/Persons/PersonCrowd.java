package Persons;

import java.io.Serializable;

public class PersonCrowd implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int gender;
	private int age;
	private int position;
	private String color;
	private int waving;
	

	public PersonCrowd(int gender, int age, int position) {
		setGender(gender);
		setAge(age);
		setPosition(position);
		setColor("");
		setWaving(0);
	}
	
	public PersonCrowd(int gender, int age, int position, String color, int waving) {
		setGender(gender);
		setAge(age);
		setPosition(position);
		setColor(color);
		setWaving(waving);
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
