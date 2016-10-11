package com.knight.solar;

import com.knight.util.MyFrame;
import java.awt.Image;
import com.knight.util.GameUtil;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

//Ì«ÑôÏµÖ÷´°¿Ú



public class SolarFrame extends MyFrame{
	
	//Image bg=GameUtil.getImage("Images/bg.jpg");
    Star bg=new Star("Images/bg.jpg",0,0);
    Star dot=new Star("Images/dot.png",150,250);
    Planet earth=new Planet("Images/earth.png",100,50,0.1,dot);
    Planet mars=new Planet("Images/earth.png",150,110,0.5,dot);//long,short,speed,center
    
	public void paint(Graphics g){
		//bg.draw(g);
		dot.draw(g);
		earth.draw(g);
		mars.draw(g);
	
	}
	
	public static void main(String[] args) {
		SolarFrame g=new SolarFrame();
		g.launchFrame();
	}
	
	

}
