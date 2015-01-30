package com.gatech.traffic;

public class Car {
	private int id;
	private int start;
	private int end;
	private int speed;
	
	public Car(int id, int start, int end, int speed) {
		this.id = id;
		this.start = start;
		this.end = end;
		this.speed = speed;
	}
	
	public int getId(){
		return this.id;
	}
	
	public int getStart(){
		return this.start;
	}
	
	public int getEnd(){
		return this.end;
	} 
	
	public int getSpeed(){
		return this.speed;
	}
}
