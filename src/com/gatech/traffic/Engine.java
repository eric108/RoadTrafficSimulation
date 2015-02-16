package com.gatech.traffic;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Engine {
	static int startTime = 0;
	static int endTime = 3000;
	static int lightStartTime = -88;
	
	public static void main(String[] args) throws FileNotFoundException {
		randomizeCarArrival();
//		unSyncTrafficLight();
		syncTrafficLight();
		int count = 0;
		while(SimData.now<endTime && !SimData.queue.isEmpty()) {
			System.out.println("Event " + count++);

			AbstractEvent event = SimData.queue.poll();
			SimData.now = event.schdule;
			event.execute();
		}
		System.out.println("All cars passed 14th: " + SimData.res.size());
		output();
	}
	
	private static void syncTrafficLight() {
		// TODO Auto-generated method stub
		for(int i = 0; i<5; i++) {
			SimData.queue.add(new LightTurnEvent(SimData.now, i));
		}
		System.out.println("Randomized Initial Traffic Lights");

	}

	private static void randomizeCarArrival() {
		RandomGenerator random = new RandomGenerator();
		double[] cars = random.GeneratePoissonArrival(startTime, endTime);
		int id = 0;
		for(double time: cars) {
			SimData.queue.add(new ArrivalEvent((int)time, 0, new Car(id++, (int)time, 25)));
			
		}
		System.out.println(cars.length + ">>>>>>>>>>>>" + SimData.queue.size());
		System.out.println("Randomized Initial Car Arrivals");
	} 
	
	private static void unSyncTrafficLight() {
		RandomGenerator random = new RandomGenerator();
		
		int[] times = new int[SimData.lightGs.length];
		for(int i= 0; i<times.length;i++) {
			times[i] = random.UniformAB(lightStartTime, 0);
		}

		for(int i =0; i<times.length; i++) {
			SimData.trafficLights[i] = 'R';
			SimData.queue.add(new LightTurnEvent(times[i], i));
		}

		System.out.println("Randomized Initial Traffic Lights");

	}
	
	private static void output() throws FileNotFoundException{
		StringBuilder bOutput = new StringBuilder();
        PrintWriter out = new PrintWriter("traffic.txt");
        
        for(Car car : SimData.res) {
        	bOutput.append(car.id).append(", ").append(car.startTime).append(", ")
        		.append(car.endTime).append(", ").append(car.travalTime).append(", ").append(car.count).append('\n');
        	
        }
        out.println(bOutput.toString());
		out.close();
	}
}
