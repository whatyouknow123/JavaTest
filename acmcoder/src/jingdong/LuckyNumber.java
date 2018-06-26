package jingdong;

import java.util.HashMap;
import java.util.Scanner;

public class LuckyNumber {
	public static int bit(int n){
		int result = 0;
		while(n!=0){
			result += n%2;
			n /= 2;
		}
		return result;
	}
	
	public static int ten(int n){
		int result = 0;
		while(n!=0){
			result+=n%10;
			n /= 10;
		}
		return result;
	}
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int max = 0;
		int[] numbers = new int[n+1];
		for(int i = 0; i<n;i++){
			numbers[i] = in.nextInt();
			if(numbers[i]>max){
				max = numbers[i];
			}
		}
		int count =0;
		HashMap<Integer, Integer> result1 = new HashMap<Integer, Integer>();
		for(int i =1; i<=max;i++){
			int bit = bit(i);
			int ten = ten(i);
			if(bit == ten){
				count++;
			}
			result1.put(i, count);
		}
		for(int i=0;i<n;i++){
			System.out.println(result1.get(numbers[i]));
		}
	}
}
