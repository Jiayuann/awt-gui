package com.knight.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputIO {
	
	public static void main(String[] args) throws IOException {
		String str="this is a file";
		File dest=new File("E:/java_mr/test/copy.txt");
		OutputStream os=new FileOutputStream(dest,true);
		
		byte[] flush=str.getBytes();
		
		try {
			os.write(flush,0, flush.length);
			os.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(null!=os)os.close();
		}
	}

	
	
}
