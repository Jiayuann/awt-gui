package com.knight.thread;
import java.lang.Thread;
import java.util.*;
import java.text.*;
public class SleepThread implements Runnable{
	private int num=20;
	private boolean flag=true;
	public void test2(){
		synchronized(this){
		if(num<=0){
			flag=false;
		}
		try{
			Thread.sleep(100);
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"鎶㈠埌浜�"+num--);
		}
	}
	
	public void test(){
		if(num<=0){
			flag=false;
		}
		try{
			Thread.sleep(100);
		}catch(Exception e){
			e.printStackTrace();
		}
				
		System.out.println(Thread.currentThread().getName()+"鎶㈠埌浜�"+num--);
	}
		@Override
		public void run(){
			while(flag){
				test();
			}
		}

	public static void main(String []args){
		SleepThread web=new SleepThread();
		//浠ｇ悊
		new Thread(web,"a").start();
		new Thread(web,"b").start();
		new Thread(web,"c").start();
	}
}
/*
public static void main(String []args)throws InterruptedException{
			int num=10;
			while(true){
					Date endTime=new Date(System.currentTimeMillis());
					System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
					endTime=new Date(endTime.getTime());
					Thread.sleep(1000);
					if(num++==20)break;
			}	
	}
	*/