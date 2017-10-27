1:package javaIO;
2:
3:import java.io.BufferedReader;
4:import java.io.FileReader;
5:import java.io.IOException;
6:
7:public class BufferedInput {
8:	public static void read(String filename) throws IOException{
9:		BufferedReader in = new BufferedReader(new FileReader(filename));
10:		StringBuilder s = new StringBuilder();
11:		String sb;
12:		while((sb=in.readLine())!=null){
13:			s.append(sb+"\n");
14:		}
15:		in.close();
16:		System.out.println(s.toString());
17:	}
18:	public static void main(String[] args){
19:		try {
20:			read(".\\src\\javaIO\\BufferedInput.java");
21:		} catch (IOException e) {
22:			// TODO Auto-generated catch block
23:			e.printStackTrace();
24:		}
25:	}
26:}
