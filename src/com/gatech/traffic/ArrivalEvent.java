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
		if(SimData.trafficLights[index] == 'G' 
				&& SimData.intersections.get(index+1).size()<SimData.capacities[index+1] 
				&& SimData.runwayFree[index] == true) {
			SimData.runwayFree[index]=false;
			SimData.queue.add(new CrossedEvent(SimData.now+1, index));
		}
	}
}
