package com.gatech.traffic;

public class Test {
	public static void main(String[] args)
	{
		RandomGenerator rg = new RandomGenerator();
		
		//double[] arrivaltime = rg.GeneratePoissonArrival(0, 900);
		//rg.Output(arrivaltime, "avtime");
		String[] s = rg.LightInitial(1);
		System.out.println("The light color is " + s[0] + " and the time is " + s[1]);
	}

}
