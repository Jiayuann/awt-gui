package com.knight.file;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class Demo01 {
public static void main(String[] args) throws IOException {

	String path="E:/java_mr/";
	String name="b.jpg";
	
	File f=new File(path);
	if(f.isDirectory()){
		String []names=f.list();
		for(String temp:names){
			System.out.println(temp);
		}
	}
	
	File [] f2=f.listFiles();
	f2=f.listFiles(new FilenameFilter(){
		@Override
		public boolean accept(File dir, String name) {
			//System.out.println(dir.getAbsolutePath());
			// TODO Auto-generated method stub
			return new File(dir,name).isFile()&&name.endsWith(".txt");
		}
		
	}
	);
	for(File temp:f2)System.out.println(temp.getAbsolutePath());
	
	
	f.createNewFile();

	
}

}
