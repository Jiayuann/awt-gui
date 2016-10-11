package com.knight.file;

import java.io.*;

public class Demo02 {
	public static void main(String[] args) {
		File src=new File("E:/java_mr/test");
		File dest=new File("E:/java_mr/copy");
		copyDir(src,dest);
		
	}
	
	public static void copyDir(File src,File dest){
		if(src.isFile()){
			try {
				copyFile(src,dest);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(src.isDirectory()){
			dest.mkdir();
			for(File temp:src.listFiles()){
				copyDir(temp,new File(dest,temp.getName()));
			}
		}
		
	}
	public static void copyFile(File src,File dest) throws IOException,FileNotFoundException {
		//File src=new File(srcPath);
		//File dest=new File(destPath);
		InputStream is=new FileInputStream(src);
		OutputStream os=new FileOutputStream(dest);
		
		byte []flush=new byte[1024];
		int len=0;
		
		while(-1!=(len=is.read(flush))){
			os.write(flush, 0, len);
		}
		os.flush();
		os.close();
		is.close();
	}

}
