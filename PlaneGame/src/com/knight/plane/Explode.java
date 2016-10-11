package com.knight.plane;

import java.awt.Graphics;
import java.awt.Image;

import com.knight.util.GameUtil;

public class Explode {
	double x,y;
	static  Image []imgs=new Image[3];
	int count;
	
	public Explode(double x,double y){
		this.x=x;
		this.y=y;
	}
	 
	static{
		for(int i=0;i<3;i++){
			imgs[i]=GameUtil.getImage("Images/boom"+i+".png");
		}
	}

	
	public void draw(Graphics g){
		if(count<3){
		g.drawImage(imgs[count],(int)x,(int)y,null);
		count++;
		}
	}

}
