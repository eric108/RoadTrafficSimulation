package com.gatech.traffic;

import java.util.PriorityQueue;

public interface EventHandler {
	public void execute(PriorityQueue<Car> queue);
}
