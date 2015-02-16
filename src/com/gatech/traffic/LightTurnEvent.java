package com.gatech.traffic;

import java.util.Random;

public class LightTurnEvent extends AbstractEvent{
	
	public LightTurnEvent(int schedule, int index) {
		this.schdule = schedule;
		this.index = index;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		if(SimData.trafficLights[index] == 'G') {
			SimData.trafficLights[index] = 'Y';
			SimData.queue.add(new LightTurnEvent(SimData.now + SimData.lightYs[index], index));
			System.out.println("Time: "+ SimData.now+ " Traffic light " + this.index+" converts from G to Y");
		} else if (SimData.trafficLights[index] == 'Y') {
			SimData.trafficLights[index] = 'R';
			SimData.queue.add(new LightTurnEvent(SimData.now + SimData.lightRs[index], index));
			System.out.println("Time: "+ SimData.now+ " Traffic light " + this.index+" converts from Y to R");

		} else {
			SimData.trafficLights[index] = 'G';
			SimData.queue.add(new LightTurnEvent(SimData.now + SimData.lightGs[index], index));
			System.out.println("Time: "+ SimData.now+" Traffic light " + this.index+" converts from R to G");

		}
		if(SimData.trafficLights[index] != 'R' 
				&& ( index==4 ||SimData.intersections.get(index+1).size()<SimData.capacities[index+1] )
				) {
			SimData.queue.add(new CrossedEvent(SimData.now+1, index));
			System.out.println("Time: "+ SimData.now+" Event "+this.getClass().getSimpleName() + ": CrossedEvent scheduled at intersection " + index);

		}
		RandomGenerator random = new RandomGenerator();
		Random r = new Random(0);
		SimData.capacities[index] += r.nextInt(4)-2;

//		SimData.capacities[index] += random.UniformAB(-2, 2);
	}

}
