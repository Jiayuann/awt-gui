package com.knight.plane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.knight.util.Constant;
import com.knight.util.GameUtil;

public class Bullet {
   double x,y;
   int speed;
   double degree;
 
   public Bullet(){};
   public Bullet(double x, double y, int speed) {
	this.x = x;
	this.y = y;
	this.speed = speed;
	this.degree = Math.random()*Math.PI*2;

}

   public Rectangle getRect(){
	   return new Rectangle((int)x,(int)y,5,5);
  }
   
public void draw(Graphics g){
	   Color c=g.getColor();
	   g.setColor(Color.yellow);
	   g.fillOval((int)x, (int)y, 5,5);
	   g.setColor(c);	
	   x+=speed*Math.cos(degree);
	   y+=speed*Math.sin(degree);
	   if(x<0||x>Constant.GAME_WIDTH)degree=Math.PI-degree;
	   if(y<0||y>Constant.GAME_HEIGHT)degree=-degree;
   }
}
