package com.gatech.traffic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class RoadTrafficEngine {
	public static void main(String[] args){
		

		init();
		
		while(SimData.time.getTime()<900) {
			System.out.println("Now: " + SimData.time.getTime());
			eventExecution();
			SimData.time.increment();
		}
		output();
		
	}
	
	private static void init() {
		System.out.println("Initializing...");
		SimData.time = new Time();
		
		Comparator<Car> comparator = new CarComparator();
		SimData.queues = new ArrayList<PriorityQueue<Car>>(5);
		for(PriorityQueue<Car> queue: SimData.queues) {
			queue = new PriorityQueue<Car>(15, comparator);
		}
		
		System.out.println("Initialization done");
	}
	
	private static void output(){
		System.out.println("Outputing traffic results...");
		
		
		
		System.out.println("Outputing done");
	}
	
	private static void eventExecution(){

	}
	
	
	private static void randomizeCar(){
		System.out.println("One new car entering 10th...");
	}
	
	private static void randomizeTrafficLight(){
		
	}
	
	private static void synchronizeTrafficLight(){
		
	}
}
