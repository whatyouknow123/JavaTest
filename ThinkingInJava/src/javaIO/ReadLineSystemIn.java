package javaIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadLineSystemIn {
	public static void main(String[] args) throws IOException{
		BufferedReader ins = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s = ins.readLine())!=null && s.length()!=0){
			System.out.println(s.toUpperCase());
		}
	}
}
