package com.knightsight.percolation;
public class Percolation{
	private int []id;
	private boolean []stat;
	private int n;
	public Percolation(int n){
		if(n<=0)
			throw new IllegalArgumentException("Argument Illegal");
		this.n=n;
		id=new int[n*n+1];
		stat=new boolean[n*n+1];
		for(int i=1;i<=n*n;i++){
			id[i]=i;
		}
	}
	
	private boolean isValidate(int i){
		if(i<=0||i>n){
			throw new IndexOutOfBoundsException("row index i out of bounds");
		}
		return true;
	}
	
	private int xyTo1d(int i,int j){
		return (i-1)*n+j;
	}
	
	private int root(int i){
		while(id[i]!=i){
			id[i]=id[id[i]];
			i=id[i];
		}
		return i;
	}
	
	private void union(int p,int q){
		int rootp=root(p);
		int rootq=root(q);
		if(rootp<rootq){
			id[rootq]=rootp;
		}else{
			id[rootp]=rootq;
		}
	}
	
	public void open(int i, int j) {
		int index=xyTo1d(i, j);
		if(isValidate(i)&&isValidate(j)){
			stat[index]=true;
			try{
			if(stat[index+1]&&j!=n)union(index,index+1);
			if(stat[index-1]&&j!=1)union(index,index-1);
			if(stat[index-n]&&i!=1)union(index,index-n);
			if(stat[index+n]&&i!=n)union(index,index+n);
			}catch(ArrayIndexOutOfBoundsException e){
				System.out.println("the point is at border");
			}
			 
		}
	}

	public boolean isOpen(int i, int j) {
		if(isValidate(i)&&isValidate(j)){
			return stat[xyTo1d(i, j)];// TODO Auto-generated method stub
		}
		return false;

	}

	public boolean isFull(int i, int j) {
		if(isValidate(i)&&isValidate(j)){
			if(root(xyTo1d(i, j))<=n&&stat[xyTo1d(i, j)]==true)
				return true;
			else
				return false;  //is site (row i, column j) full?	
		}
		return false;
	}

	public boolean percolates() {
		for(int i=1;i<=n;i++){
			if(isFull(n, i))
				return true;
		}
		return false; // TODO Auto-generated method 
	}
	
	public static void main(String[] args) {
		Percolation p=new Percolation(3);
		p.open(1, 2);
		p.open(2, 2);
		p.open(2, 3);
		p.open(3, 3);
		System.out.println(p.isFull(1, 1));
		
	}
	
}