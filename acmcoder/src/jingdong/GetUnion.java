package jingdong;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class GetUnion {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int aSize = in.nextInt();
			int bSize = in.nextInt();
			Set a = new HashSet();
			for(int i = 0; i<aSize; i++){
				a.add(in.nextInt());
			}
			Set b = new HashSet();
			for(int i = 0; i<bSize; i++){
				b.add(in.nextInt());
			}
			ArrayList result = new ArrayList();
			a.addAll(b);
			result.addAll(a);
			Collections.sort(result);
			for(int i = 0; i<result.size(); i++){
				System.out.print(result.get(i));
				System.out.print(" ");
			}
			System.out.println();
			
		}
	}
}
