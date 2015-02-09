package com.gatech.traffic;

public class ArrivalEvent extends AbstractEvent{
	Car car;
	public ArrivalEvent(int schedule, int index, Car car) {
		this.schdule = schedule;
		this.index = index;
		this.car = car;
	}
	
	public void execute() {
		SimData.intersections.get(index).offer(car);
		if(SimData.trafficLights[index] != 'R' 
				&& ( index==4 ||SimData.intersections.get(index+1).size()<SimData.capacities[index+1] )
				&& SimData.runwayFree[index] == true) {
			SimData.runwayFree[index]=false;
			SimData.queue.add(new CrossedEvent(SimData.now+1, index));
			System.out.println("Time: "+ SimData.now+" Event "+this.getClass().getSimpleName() + ": CrossedEvent scheduled at intersection " + index);

		}
	}
}
