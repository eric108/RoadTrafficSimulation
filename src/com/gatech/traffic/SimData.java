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
	public static char[] trafficLights = {'R', 'R', 'R', 'R', 'R'};
	public static int[] sectionTravelTime = {9, 9, 9, 7};
	
	public static int[] lightGs = {35, 41, 61, 63, 35};
	public static int[] lightYs = {4, 3, 3, 3, 3};
	public static int[] lightRs = {49, 55, 35, 11, 46};
	
//	public final static double LIGHT0G = 34.7;
//	public final static double LIGHT0Y = 3.6;
//	public final static double LIGHT0R = 49.3;
//
//	public final static double LIGHT1G =41.5;
//	public final static double LIGHT1Y = 3.2;
//	public final static double LIGHT1R = 55.4;
//	
//	public final static double LIGHT2G = 60.9;
//	public final static double LIGHT2Y = 3.2;
//	public final static double LIGHT2R = 35.7;
//	
//	public final static double LIGHT3G = 62.9;
//	public final static double LIGHT3Y = 3.2;
//	public final static double LIGHT3R = 10.5;
//	
//	public final static double LIGHT4G = 34.6;
//	public final static double LIGHT4Y =3.2;
//	public final static double LIGHT4R = 46.1;
	
	public final static double ROAD10_11 = 121.0; 
	public final static double ROAD11_12 = 117.96;
	public final static double ROAD12_13 = 100.89;
	public final static double ROAD13_14 = 92.96;

}
