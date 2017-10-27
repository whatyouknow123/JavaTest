package javaIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedInput {
	public static void read(String filename) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader(filename));
		StringBuilder s = new StringBuilder();
		String sb;
		while((sb=in.readLine())!=null){
			s.append(sb+"\n");
		}
		in.close();
		System.out.println(s.toString());
	}
	public static void main(String[] args){
		try {
			read(".\\src\\javaIO\\IOSet.out");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
