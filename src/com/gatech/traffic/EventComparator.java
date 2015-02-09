package com.gatech.traffic;

import java.util.Comparator;


public class EventComparator implements Comparator<AbstractEvent>{

	@Override
	public int compare(AbstractEvent event1, AbstractEvent event2) {
		// TODO Auto-generated method stub
		return event1.schdule - event2.schdule;
		
	}

}
