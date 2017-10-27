package myArray;

import java.util.Arrays;

class Banana{
	int id = 0;
	Banana(int ids){
		this.id = ids;
	}
}
public class ArrayEqual {
	public static void main(String[] args){
		Banana[] b1 = new Banana[10];
		Banana[] b2 = new Banana[10];
		Arrays.fill(b1, new Banana(3));
		Arrays.fill(b2, new Banana(6));
		System.out.println(Arrays.equals(b1, b2));
		}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
