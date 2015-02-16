package com.gatech.traffic;

public class CrossedEvent extends AbstractEvent{

	public CrossedEvent(int schedule, int index) {
		this.schdule = schedule;
		this.index = index;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		if(SimData.intersections.get(index).size()==0) return;
		Car car = SimData.intersections.get(index).poll();
		if(index==0) car.startTime = SimData.now;
		if(index>=1)SimData.queue.add(new CrossedEvent(SimData.now+1, index-1));
		if(index==4) {
			car.calTravelTime(SimData.now);
			car.count = ++SimData.total;
			SimData.res.add(car);
			SimData.runwayFree[index] = true;
			System.out.println("Time: " + SimData.now + " Event " + this.getClass().getSimpleName() + " for Car "+car.id+" at intersection 4");
		} else {
			SimData.queue.add(new ArrivalEvent(SimData.now+(int)(SimData.ROAD10_11/car.speed), index+1, car));
			System.out.println("Time: " + SimData.now + " Event " + this.getClass().getSimpleName() +
				": ArrivalEvent scheduled for Car " + car.id + " at intersection " + index);
		}
		if(SimData.trafficLights[index] != 'R' 
				&& ( index==4 ||SimData.intersections.get(index+1).size()<SimData.capacities[index+1] )
				) {
			SimData.queue.add(new CrossedEvent(SimData.now+1, index));
			System.out.println("Time: "+ SimData.now+" Event "+this.getClass().getSimpleName() + ": CrossedEvent scheduled for Car "+ car.id+" at intersection " + index);
		}else {
			SimData.runwayFree[index] = true;
		}

	}

}
