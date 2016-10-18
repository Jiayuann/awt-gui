package com.knight.thread;
import java.io.File;
import java.io.Reader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.io.FileWriter;
public class ReadIO{
	public static void main(String []args) throws IOException{
		//仅限于字符纯文本
		File src=new File("D:/Web/c1.css");
		File des=new File("D:/Web/Co.css");
		Reader r=new FileReader(src);
		Writer w=new FileWriter(des);
		char []ch=new char[1024];
		int len=0;
		while(-1!=(len=r.read(ch))){
			w.write(ch,0,len);
			System.out.println(new String(ch,0,len));
		}
		w.flush();
		r.close();
		w.close();
	}
}