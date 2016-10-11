package com.knightsight.percolation;

public class PercolationStats {
			private int n;
			private int trials;
		   public PercolationStats(int n, int trials){
			   if(n<=0||trials<=0)
				   throw new IllegalArgumentException("Illegal");
			   this.n=n;
			   this.trials=trials;
		   }    // perform trials independent experiments on an n-by-n grid
		   public double mean() { // sample mean of percolation threshold
			   
			   	return 1;
		   }
		   public double stddev(){  // sample standard deviation of percolation threshold
			   return 1;
		   }                      
		   public double confidenceLo(){  // low  endpoint of 95% confidence interval
			   return 1;
		   }               
		   public double confidenceHi(){
			   return 1;
		   }                 // high endpoint of 95% confidence interval

		   public static void main(String[] args){
			   
			   
		   }    // test client (described below)
	
}
