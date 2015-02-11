package com.gatech.traffic;
import java.util.Date;
import java.util.Arrays;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class RandomGenerator {
	
	//double[] timestamp;
	Date date = new Date();
	long seed = date.getTime();
	public double RandomNumber()  //(0,1) Uniform Distribution
	{
		//Date date = new Date();
		//long seed = date.getTime();
		//System.out.println(Long.toString(this.seed));
		final long m = 2147483647;
		final long a = 48271;
		final long q = 44488;
		final long r = 3399;
		long t = a * (this.seed % q) - r * (this.seed / q);
		if (t > 0)
			this.seed = t;
		else
			this.seed = t + m;
		return ((double) this.seed/m);
	}
	
	public double UniformAB(double lower, double upper) // [a,b]Uniform Distribution
	{
		RandomNumber();
		RandomNumber();
		return Math.floor(lower + (upper - lower) * RandomNumber());
	}
	
	public double Exponential(float mu) // Exponential Distribution with mean = mu
	{
		RandomNumber();
		RandomNumber();
		return -mu * Math.log(1 - RandomNumber());
	}
	
	public int Poisson(int mu) //Poisson Distribution with mean = mu
	{
		RandomNumber();
		RandomNumber();
		double temp = 0.0;
		int x = 0;
		while (temp < mu)
		{
			temp += Exponential(1);
			x++;
		}
		//this.timestamp = new double[x - 1];
		return x - 1;
	}
	
	public double Gaussian(int mu, float sigma) //Gaussian Distribution with mean = mu and standard deviation = sigma
	{
		RandomNumber();
		RandomNumber();
		double u= 0, v = 0, s=1;
		while (s >= 1 || s == 0)
		{
			u = RandomNumber() * 2 - 1;
			v = RandomNumber() * 2 - 1;
			s = u * u + v * v;
		}
			double mul = Math.sqrt(-2.0 * Math.log(s) / s);
			return (mu + sigma * u * mul);
	}
	
	public double[] GeneratePoissonArrival(int start, int end)
	{
		
		int CarNum = Poisson(149);
		System.out.println(Integer.toString(CarNum));
		double[] u = new double[CarNum];
		u[0] = RandomNumber();
		u[0] = RandomNumber();
		for(int i = 0; i < CarNum; i++)
		{
			u[i] = RandomNumber();
		}
		Arrays.sort(u);
		double[] timestamp = new double[CarNum];
		for(int i = 1; i < CarNum; i++)
		{
			timestamp[i] = (int)(start + (end - start) * u[i]);
		}
		return timestamp;
	}
	
	public void Output(double[] OutArray, String distribution)
	{
		String output = "./output/" + distribution + ".txt";
		try
		{
			//FileWriter testfile = new FileWriter(output);
			//BufferedWriter bf = new BufferedWriter(testfile);
			PrintWriter pw = new PrintWriter(output);
			for(double d : OutArray)
			{
				pw.println(Double.toString(d));
			}
			pw.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}		
	}
	
	
	
}

