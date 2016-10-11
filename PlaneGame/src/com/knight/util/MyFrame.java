package com.knight.util;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame{
	//¼ÓÔØ´°¿Ú
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
	
	private Image offScreenImage=null;
	public void update(Graphics g){
		if(offScreenImage==null)offScreenImage=this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		Graphics gOFF=offScreenImage.getGraphics();
		paint(gOFF);
		g.drawImage(offScreenImage,0,0,null);	
	}
	
	
	
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



   
