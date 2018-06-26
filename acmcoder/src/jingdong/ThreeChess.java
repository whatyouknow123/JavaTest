package jingdong;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ThreeChess {
	public static ArrayList<String> whoWin(char[][] table){
		ArrayList<String> record = new ArrayList<String>();
		for(int i = 0; i<3;i++){
			char[] value = {table[i][0], table[i][1], table[i][2]};
			record.add(String.valueOf(value));
		}
		for(int j= 0; j<3;j++){
			char[] value = {table[0][j], table[1][j], table[2][j]};
			record.add(String.valueOf(value));
		}
		char[] value = {table[0][0], table[1][1], table[2][2]};
		record.add(String.valueOf(value));
		char[] value2 = {table[0][2], table[1][1], table[2][0]};
		record.add(String.valueOf(value2));
		return record;
	}
	public static void main(String args[]) throws IOException{
		Scanner in = new Scanner(System.in);
		char[][] table = new char[3][3];
		
		while(in.hasNext()){
			int x = 0;
			int o = 0;
			int zero = 0;
			for(int i = 0; i<3;i++){
				String value = in.next();
				for(int j = 0; j<3; j++){
					table[i][j] = value.charAt(j);
					if(table[i][j]=='0'){
						o++;
					}else if(table[i][j] == 'X'){
						x++;
					}else{
						zero++;
					}
				}
			}
			
			if((x-o)!=1&&(x-o)!=0){
				System.out.println('x');
			
			}else{
				ArrayList record = whoWin(table);
//				for(int i = 0; i<record.size();i++){
//					System.out.println(record.get(i));
//				}
				if(zero == 0){
					if(record.contains("000")){
						System.out.println("2 won");
					}else if(record.contains("XXX")){
						System.out.println("1 won");
					}else{
						System.out.println("Draw");
					}
				}else{
					if(x>o){
						if(record.contains("000")){
							System.out.println("x");
						}else{
							if(record.contains("XXX")){
								System.out.println("1 won");
							}else{
								System.out.println("2");
							}
						}
					}else{
						if(record.contains("XXX")){
							System.out.println("x");
						}else{
							if(record.contains("000")){
								System.out.println("2 won");
							}else{
								System.out.println("1");
							}
						}
					}
				}
			}
		
		}
		
	}
}
