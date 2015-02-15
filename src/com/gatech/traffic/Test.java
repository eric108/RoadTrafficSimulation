package com.gatech.traffic;

public class Test {
	public static void main(String[] args)
	{
		RandomGenerator rg = new RandomGenerator();
		
		//double[] arrivaltime = rg.GeneratePoissonArrival(0, 900);
		//rg.Output(arrivaltime, "avtime");
		//int[] rand= new int[10];
		for(int i = 0;i<10;i++){
			System.out.println(Integer.toString(rg.UniformAB(-2, 2)));
		}
		
	}

}
