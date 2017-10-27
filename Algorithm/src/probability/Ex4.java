package probability;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Ex4 {
	private int uniform(Set<Integer> x){
		Random rand = new Random();
		int position = rand.nextInt(x.size());
		int result = 0;
		Iterator it = x.iterator();
		for(int i = 0;i<=position;i++){
			result = (Integer) it.next();
		}
		return result;
	}
	private int setCount(Set<Integer> x){
		int k =0;
		Set<Integer> s = new HashSet<Integer>();
		int a = uniform(x);
		do{
			k++;
			s.add(a);
			a = uniform(x);
		}while(s.contains(a)==false);
		return (int) ((int)2*k*k/Math.PI);
		
	}
	private Set<Integer> initialSet(Set<Integer> x, int n){
		for(int i = 1;i<=n;i++){
			x.add(i);
		}
		return x;
	}
	public static void main(String[] args){
		Ex4 ex = new Ex4();
		Set<Integer> x = new HashSet<Integer>();
		int n = 0;
		while(true){
			Scanner s = new Scanner(System.in);
			n = s.nextInt();
			ex.initialSet(x, n);
			int sum = 0;
			//set the average value as result 
			for(int i = 0; i<100;i++){
				sum += ex.setCount(x);
			}
			int result = sum/100;
			System.out.println("the n is "+n+" the result is "+result+"\n");
		}
		
	}
}
