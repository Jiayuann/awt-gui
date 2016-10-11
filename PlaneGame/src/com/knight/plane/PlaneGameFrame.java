package com.knight.plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import com.knight.util.Constant;
import com.knight.util.GameUtil;
import com.knight.util.MyFrame;

public class PlaneGameFrame extends MyFrame{
	
	Image bg=GameUtil.getImage("Images/bg.jpg");
	Plane p=new Plane("Images/plane.png",150,250);
	ArrayList bulletList=new ArrayList();
	Date startTime,currTime,endTime;

 
	public void paint(Graphics g){
		g.drawImage(bg, 0, 0, null);
		p.draw(g);
		
		currTime=new Date();
		int curr=(int)(currTime.getTime()-startTime.getTime())/1000;
		printInfo(g,"time is "+curr+" sec",20,300,50,Color.white);
		for(int i=0;i<bulletList.size();i++){
			Bullet b=(Bullet) bulletList.get(i);
			b.draw(g);	
			boolean poon=b.getRect().intersects(p.getRect());
		
			if(poon) {
				p.live=false;
				if(endTime==null)
				 endTime=new Date();	
			}
		}	
		
		
		if(p.live==false){
			int period=(int)(endTime.getTime()-startTime.getTime())/1000;
			printInfo(g, "时间:"+period+"秒", 40, 200, 200, Color.white);
			switch(period/10){
			case 0:
				printInfo(g,"太菜了！",50,100,100,Color.yellow);
				break;
			case 1:
				printInfo(g,"菜鸟！！",50,100,100,Color.GREEN);
				break;
			case 2:
				printInfo(g,"这个还行",50,100,100,Color.GREEN);
				break;
			case 3:
				printInfo(g,"你吊",50,100,100,Color.GREEN);
				break;
			default:
				printInfo(g,"excellent!!!",50,100,100,Color.GREEN);
				break;
			
			}
			
		}
		
	}
	
	public void printInfo(Graphics g,String str,int size,double x,double y,Color color){
			Color c=g.getColor();
			g.setColor(color);
			Font f=new Font("song",Font.BOLD,size); 	
			g.setFont(f);
			g.drawString(str, (int)x,(int)y);
			g.setColor(c);
	}
	
	
	public void launchFrame(){
		super.launchFrame();
		addKeyListener(new KeyMonitor());
		for(int i=0;i<Constant.BULLET_NUM;i++){
			Bullet b=new Bullet(100,100,Constant.speed/2);
			bulletList.add(b);
		}
		startTime=new Date();
	}
	
	
	
	
	//define as inner class
	class KeyMonitor extends KeyAdapter{
	
		@Override
		public void keyReleased(KeyEvent e) {
		
			p.delDirection(e);
			// TODO Auto-generated method stub
			System.out.println("release a key"+e.getKeyCode());
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			System.out.println("press a key"+e.getKeyCode());
			p.addDirection(e);
			}
		
		
		}
		
	
	public static void main(String[] args) {
		PlaneGameFrame g=new PlaneGameFrame();
		g.launchFrame();
	}

}


