package com.gatech.traffic;

public class Test {
	public static void main(String[] args)
	{
		RandomGenerator rg = new RandomGenerator();
		
		double[] TestUni = new double[100000];
		rg.RandomNumber();
		rg.RandomNumber();
		for (int i = 0; i < 100000; i++)
		{
			TestUni[i] = rg.Exponential(1);
		}
		rg.Output(TestUni, "Exponential");
	}

}
