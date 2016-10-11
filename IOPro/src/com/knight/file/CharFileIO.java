package com.knight.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class CharFileIO {
	public static void main(String []args) throws IOException{
		File src=new File("E:/java_mr/test/copy.txt");
		Reader reader=null;
		try {
			reader=new FileReader(src);
			char []flush=new char[1024];
			int len=0;	 
			while(-1!=(len=reader.read(flush))){
				String str=new String(flush,0,len);
				System.out.println(str);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			reader.close();
		}
		
		
		
	}

}
