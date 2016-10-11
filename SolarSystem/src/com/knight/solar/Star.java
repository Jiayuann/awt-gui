package com.knight.solar;

import java.awt.Image;

import com.knight.util.GameUtil;

import java.awt.Graphics;
public class Star {
  Image img;
  double x,y;
  public void draw(Graphics g){
	  g.drawImage(img, (int)x, (int)y,null);
  }
  
  public Star(){};
  public Star(Image img,int x, int y){
	  this.x=x;
	  this.y=y;
	  this.img=img;
  }
  
  public Star(String str,int x, int y){
	  this.x=x;
	  this.y=y;
	  this.img=GameUtil.getImage(str);
  }
  
}
