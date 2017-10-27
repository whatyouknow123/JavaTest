package javaIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class ReadLine {
	public static void read(String filename) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader(filename));
		LinkedList list = new LinkedList();
		String sb;
		while((sb=in.readLine())!=null){
			list.add(sb+"\n");
		}
		in.close();
		for(int index = list.size()-1;index>=0;index--){
			System.out.println(list.get(index)+"\n");
		}
	}
	
	public static void writer(String filename) throws IOException{
		String fileout = "ReadLine2.java";
		PrintWriter out = new PrintWriter(fileout);
		BufferedReader in = new BufferedReader(new FileReader(filename));
		LinkedList list = new LinkedList();
		String sb;
		int lines = 1;
		while((sb=in.readLine())!=null){
			out.println(lines++ + ":"+sb);
		}
		in.close();
		out.close();
		read(".\\src\\javaIO\\ReadLine.java");
	}
	public static void main(String[] args){
		try {
			read(".\\src\\javaIO\\BufferedInput.java");
			writer(".\\src\\javaIO\\BufferedInput.java");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
