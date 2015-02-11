package com.gatech.traffic;

public class Test {
	public static void main(String[] args)
	{
		RandomGenerator rg = new RandomGenerator();
		
		double[] arrivaltime = rg.GeneratePoissonArrival(0, 900);
		rg.Output(arrivaltime, "avtime");
	}

}
