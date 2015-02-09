package com.gatech.traffic;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Engine {
	
	public static void main(String[] args) throws FileNotFoundException {
		SimData.now = 0;
		randomizeCarArrival();
		randomizeTrafficLight();
		int count = 0;
		while(SimData.now<500 && !SimData.queue.isEmpty()) {
			System.out.println("Event " + count++);

			AbstractEvent event = SimData.queue.poll();
			SimData.now = event.schdule;
			event.execute();
		}
		System.out.println("All cars passed 14th: " + SimData.res.size());
		output();
	}
	
	private static void randomizeCarArrival() {
		SimData.queue.add(new ArrivalEvent(SimData.now+3, 0, new Car(0, SimData.now+3)));

		SimData.queue.add(new ArrivalEvent(SimData.now+5, 0, new Car(1, SimData.now+5)));

		SimData.queue.add(new ArrivalEvent(SimData.now+7, 0, new Car(2, SimData.now+7)));
		System.out.println("Randomized Initial Car Arrivals");
	} 
	
	private static void randomizeTrafficLight() {
		for(int i = 0; i<5; i++) {
			SimData.queue.add(new LightTurnEvent(SimData.now, i));
		}
		System.out.println("Randomized Initial Traffic Lights");

	}
	
	private static void output() throws FileNotFoundException{
		StringBuilder bOutput = new StringBuilder();
        PrintWriter out = new PrintWriter("traffic.txt");
        
        for(Car car : SimData.res) {
        	bOutput.append(car.id).append(", ").append(car.startTime).append(", ")
        		.append(car.endTime).append(", ").append(car.travalTime).append('\n');
        	
        }
        out.println(bOutput.toString());
		out.close();
	}
}
