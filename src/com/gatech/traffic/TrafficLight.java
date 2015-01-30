package com.gatech.traffic;

public class TrafficLight {
	private int gLight;
	private int yLight;
	private int rLight;
	
	public TrafficLight(int gLight, int yLight, int rLight) {
		this.gLight = gLight;
		this.yLight = yLight;
		this.rLight = rLight;
	}
	
	public int getGLight() {
		return this.gLight;
	}
	
	public int getYLight() {
		return this.yLight;
	}
	
	public int getRLight() {
		return this.rLight;
	}
}
