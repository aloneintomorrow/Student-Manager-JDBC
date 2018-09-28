package com.vietjack.core;

public class Student {
	private int id;
	private String name;
	private String dob;
	private Subject math;
	private Subject physics;
	
	public Student() {
		super();
	}
	public void inputID(int idMath,int idPhysics) {
		math = new Subject();
		math.setId(idMath);
		physics = new Subject();
		physics.setId(idPhysics);
	}
	public int getIDMath() {
		return math.getId();
	}
	public int getPhysics() {
		return physics.getId();
	}
	public Student(int id, String name,String dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + name + dob;
	}
}
