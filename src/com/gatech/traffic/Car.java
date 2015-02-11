package com.gatech.traffic;

public class Car {
	int startTime;
	int endTime;
	int travalTime;
	int id;
	int count;
	public Car(int id, int startTime) {
		this.id = id;
		this.startTime = startTime;
	}
	public void calTravelTime(int endTime) {
		this.endTime = endTime;
		this.travalTime = this.endTime-this.startTime;
		System.out.println("Car " + this.id + " finished the travel from "
				+ this.startTime + " to "+ this.endTime);
	}
}
