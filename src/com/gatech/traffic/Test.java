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
			TestUni[i] = rg.RandomNumber();
		}
		rg.Output(TestUni, "0_1");
	}

}
