package com.gatech.traffic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SimData {
	// all variables here must be static
	private static  Comparator<AbstractEvent> comparator = new EventComparator();
	public static PriorityQueue<AbstractEvent> queue = new PriorityQueue<AbstractEvent>(11, comparator);
	public static int now = 0;
	public static ArrayList<Car> res = new ArrayList<Car>();
	public static boolean[] runwayFree = {true, true, true, true, true};
	@SuppressWarnings("serial")
	public static List<LinkedList<Car>> intersections  = new ArrayList<LinkedList<Car>>(){{
	    add(new LinkedList<Car>());
	    add(new LinkedList<Car>());
	    add(new LinkedList<Car>());
	    add(new LinkedList<Car>());
	    add(new LinkedList<Car>());
	}};
	
	public static int[] capacities = {Integer.MAX_VALUE, 24, 24, 20, 19};
	public static char[] trafficLights = {'G', 'G', 'G', 'G', 'G'};
}
