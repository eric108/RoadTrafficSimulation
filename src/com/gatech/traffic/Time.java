package com.gatech.traffic;

public class Time {
	private static int time;
	
	public Time() {
		this.time = 0;
	}
	
	public void increment() {
		time++;
	}
	
	public void increment(int inc) {
		time+=inc;
	}
	
	public int getTime() {
		return this.time;
	}
}
