package com.knight.collection2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class demo01 {
public static void main(String[] args) throws FileNotFoundException, IOException {
	Properties pro=new Properties();
	//pro.setProperty("drivers", "jdbc.drivers");
	//pro.store(new FileOutputStream(new File("E:/demo.properties")), "new file");
	//pro.storeToXML(new FileOutputStream(new File("E:/demo.xml")), "new file");
	pro.load(new FileReader("E:/demo.properties"));
	System.out.println(pro.getProperty("drivers","this"));
}
}