package com.knight.thread;
import java.lang.Thread;

public class MyThreadApp{
	public static class MyThread extends Thread{
    @Override
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println("rabbit runs"+i+"steps");
		}
	}
   }
   public static class MyThread2 extends Thread{
    @Override
	public void run(){
		for(int i=0;i<10;i++)                                                                                                                                                                                                            
			System.out.println("tortose runs"+i+"steps");
		}
	}
   
   
public static void main(String[] args){
		MyThread th=new MyThread();
		MyThread2 th2=new MyThread2();
		th2.start();th.start();
		for(int i=0;i<100;i++)System.out.println("main->"+i);
		
	}
}