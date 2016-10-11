package com.knight.solar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import com.knight.util.GameUtil;

public class Planet extends Star {
	double longAxis;
	double shortAxis;
	double speed;
	double degree;
	Star center;

	public void draw(Graphics g){
		super.draw(g);
		Color c=g.getColor();
		g.setColor(Color.green);
		
		g.drawOval((int)(center.x-longAxis), (int)(center.y-shortAxis), (int)(2*longAxis), (int)(2*shortAxis));
		g.setColor(c);
		x=center.x-10+longAxis*Math.cos(degree);
		y=center.y-10+shortAxis*Math.sin(degree);
		degree+=speed;
		
		
	}
	
	public Planet(String str,double longAxis,double shortAxis,double speed,Star center){
		this.longAxis=longAxis;
		this.shortAxis=shortAxis;
		this.speed=speed;
		this.center=center;
		
		this.x=center.x+longAxis;
		this.y=center.y;  
		this.img=GameUtil.getImage(str);
	
		
	}
	
	public Planet(Image img, int x, int y) {
		super(img, x, y);
		// TODO Auto-generated constructor stub
	}
	
	public Planet(String str, int x, int y) {
		super(str, x, y);
		// TODO Auto-generated constructor stub
	}

	
}
