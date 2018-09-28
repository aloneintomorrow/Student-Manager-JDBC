package com.vietjack.core;

public class Subject {
	private int id;
	private String mark;
	
	public Subject(int id, String mark) {
		super();
		this.id = id;
		this.mark = mark;
	}
	public Subject() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
}
