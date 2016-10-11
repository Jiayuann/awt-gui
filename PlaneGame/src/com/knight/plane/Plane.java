package com.knight.plane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Date;

import com.knight.util.Constant;
import com.knight.util.GameUtil;

public class Plane{
  double x,y;
  Image  img;
  boolean right,left,up,down;
  boolean live=true;
  int width,height;

  
  
  public Plane(String str,double x,double y){
	  this.x=x;
	  this.y=y;
	  this.img=GameUtil.getImage(str);
		  this.width=img.getWidth(null); 
	  this.height=img.getHeight(null);
  }
  
  public Plane(){};
  
  public Rectangle getRect(){
	   return new Rectangle((int)x,(int)y,width,height);
  }
  
  public void addDirection(KeyEvent e){
	  
	  switch(e.getKeyCode()){
		case KeyEvent.VK_LEFT:
			left=true;
			break;
		case KeyEvent.VK_RIGHT:
			right=true;
			break;
		case KeyEvent.VK_UP:
			up=true;
			break;
		case KeyEvent.VK_DOWN:
			down=true;
			break;
		default:
			break;
		}
	  
  }
  
  public void delDirection(KeyEvent e){
	  switch(e.getKeyCode()){
		case KeyEvent.VK_LEFT:
			left=false;
			break;
		case KeyEvent.VK_RIGHT:
			right=false;
			break;
		case KeyEvent.VK_UP:
			up=false;
			break;
		case KeyEvent.VK_DOWN:
			down=false;
			break;
		default:
			break;
		}
	 
  }
  
  public void move(){

	  if(left&&x>0){
		  x-=Constant.speed;
		  System.out.println(x);
	  }
	  if(right&&x<500-img.getWidth(null)){
		  x+=Constant.speed;
		  System.out.println(x);
	  }
	  if(up&&y>0){
		  y-=Constant.speed; 
	  }
	  if(down&&y<400-img.getHeight(null)){
		  y+=Constant.speed;
	  }
     
  }
  
  
  public void draw(Graphics g){
	  if(live){
	  g.drawImage(img,(int)x,(int)y,null);
	  move();
	  }
	 else
	 new Explode(x,y).draw(g);
}
}