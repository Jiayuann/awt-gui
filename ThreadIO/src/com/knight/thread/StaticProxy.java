package com.knight.thread;
import java.lang.Thread;
public class StaticProxy{
	public static class Programmer implements Runnable{
	
	@Override
	public void run(){
		for(int i=0;i<100;i++)
		System.out.println("hello world");
	}
}
	
	public static void main(String []args){
		Programmer pro=new Programmer();
		Thread proxy =new Thread(pro);
		proxy.start();
		for(int i=0;i<100;i++){
			System.out.println("chat on qq");
		}
	}
}