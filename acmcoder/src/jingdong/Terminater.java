package jingdong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;


public class Terminater {
	
	public static HashSet<Integer> findLsit(int x, int[][] cars, int n){
		HashSet<Integer> result = new HashSet<Integer>();
		for(int i = 0; i<n; i++){
			if(cars[i][0]<=x&&cars[i][1]>=x){
				result.add(i);
			}
		}
		return result;
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[][] cars = new int[n+1][2];
		for(int i =0; i<n; i++){
			int x = in.nextInt();
			int l = in.nextInt();
			cars[i][0] = x;
			cars[i][1] = x+l;
		}
		int result = 0;
		for(int i = 0; i<n-1;i++){
			for(int j = i+1; j<n;j++){
				HashSet x1 = findLsit(cars[i][0], cars, n);
				HashSet y1 = findLsit(cars[i][1], cars, n);
				HashSet x2 = findLsit(cars[j][0], cars, n);
				HashSet y2 = findLsit(cars[j][1], cars, n);
				HashSet temp = new HashSet();
				temp.addAll(x1);
				HashSet temp2 = new HashSet();
				temp2.addAll(y1);
				x1.addAll(x2);
				temp.addAll(y2);
				y1.addAll(x2);
				temp2.addAll(y2);
				if(result<x1.size()){
					result = x1.size();
				}
				if(result<temp.size()){
					result = temp.size();
				}
				if(result<y1.size()){
					result = y1.size();
				}
				if(result<temp2.size()){
					result = temp2.size();
				}
				
			}
		}
		System.out.println(result);
	}
}
