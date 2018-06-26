package jingdong;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Set;

public class ClimbingMountain {
	public static boolean test(HashMap<Integer, Integer> result){
		Iterator<Integer> keys = result.keySet().iterator();
		boolean flag= true;
		int key1 = keys.next();
		while(keys.hasNext()){
		
				int key2 = keys.next();
				if((result.get(key2)-result.get(key1))>(key2-key1)||(result.get(key2)-result.get(key1))<(key1-key2)){
					flag = false;
					break;
				}else{
					key1 = key2;
				}
			
			
		}
		return flag;
	}
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int m = in.nextInt();
			int n = in.nextInt();
			HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();
			for(int i= 0;i<n;i++){
				int key = in.nextInt();
				int value = in.nextInt();
				result.put(key, value);
			}
			if(test(result)){
				Iterator<Integer> keys = result.keySet().iterator();
				int head = keys.next();
				int headvalue = result.get(head)+head-1;
				int max = headvalue;
				int temp=0;
				while(keys.hasNext()){
					temp = keys.next();
					int tempvalue = (temp-head+result.get(temp)+result.get(head))/2;
					if(tempvalue>max){
						max = tempvalue;
					}
					head = temp;
				}
				int endvalue = result.get(temp)+n-temp;
				if(endvalue>max){
					max = endvalue;
				}
				System.out.println(max);
			}else{
				System.out.println("IMPOSSIBLE");
			}
		}
	}
}
