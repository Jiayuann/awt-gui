package com.knight.test;

import java.awt.Frame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame{
	//加载窗口
	public void launchFrame(){
		 setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		 setLocation(Constant.LOC_WIDTH,Constant.LOC_HEIGHT);
		 setVisible(Constant.VISIBLE);
		 
		 new PaintThread().start();
	
		 addWindowListener(
				   new WindowAdapter(){
                   @Override
					public void windowClosing(WindowEvent e) {System.exit(0);} 
                   }
		   );   
	}
	
	//线程重复；
	class PaintThread extends Thread{
		   public void run(){
			   while(true){
				   repaint();
				   try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   }
		   }
		   
	   }

}
