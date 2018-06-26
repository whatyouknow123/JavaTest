package jingdong;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class JudgeCharacter {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		String a = in.next();
		String b = in.next();
		char[] aArray = a.toCharArray();
		char[] bArray = b.toCharArray();
		Map aMap = new HashMap<String, Integer>();
		Map bMap = new HashMap<String, Integer>();
		for(int i= 0; i<aArray.length; i++){
			if(aMap.containsKey(aArray[i])){
				int value = (Integer) aMap.get(aArray[i]);
				aMap.put(aArray[i], value+1);				
			}else{
				aMap.put(aArray[i], 1);
			}
		}
		for(int i= 0; i<bArray.length; i++){
			if(bMap.containsKey(bArray[i])){
				int value = (Integer) bMap.get(bArray[i]);
				bMap.put(bArray[i], value+1);				
			}else{
				bMap.put(bArray[i], 1);
			}
		}
		Set<Character> set = bMap.keySet();
		for(char key:set){
			if(aMap.containsKey(key)){
				if((Integer)aMap.get(key)<(Integer)bMap.get(key)){
					System.out.println("0");
					return;
				}
			}else{
				System.out.println("0");
				return;
			}
			
		}
		System.out.println("1");
	}
}
