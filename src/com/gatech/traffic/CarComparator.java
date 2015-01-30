package com.gatech.traffic;

import java.util.Comparator;

public class CarComparator implements Comparator<Car>{

	@Override
	public int compare(Car car1, Car car2) {
		// TODO Auto-generated method stub
		if(car1.getSpeed()<=car2.getSpeed()) {
			return -1;
		} else {
			return 1;
		}
	}

}
