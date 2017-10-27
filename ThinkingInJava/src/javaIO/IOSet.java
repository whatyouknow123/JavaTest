package javaIO;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class IOSet {
	public static void main(String[] args) throws IOException{
		PrintStream console = System.out;
		BufferedInputStream bf = new BufferedInputStream(new FileInputStream(".\\src\\javaIO\\IOSet.java"));
		PrintStream out = new PrintStream(".\\src\\javaIO\\IOSet.out");
		System.setIn(bf);
		System.setOut(out);
		System.setErr(out);
		BufferedReader reads = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s = reads.readLine())!= null){
			System.out.println(s);
		}
		out.close();
		System.setOut(console);
	}
}
