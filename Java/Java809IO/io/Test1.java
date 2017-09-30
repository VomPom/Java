package WORK.Java.Java809IO.io;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test1 {
	public static void main (String[] args) throws IOException {
		InputStream in=System.in;
		FileWriter fw=new FileWriter("word.txt",true);
		BufferedReader br=new BufferedReader(new InputStreamReader(in));
		
		String str=null;
		while(!(str=br.readLine()).equals("#")) {
			fw.write(str.toUpperCase());
		}
		fw.flush();
		fw.close();
		br.close();
	}

}
