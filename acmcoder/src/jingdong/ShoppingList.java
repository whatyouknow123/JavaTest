package jingdong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

class food implements Comparable<food>{
	private String name;
	private int number;
	public void setName(String name){
		this.name = name;
	}
	public void setNumber(int number){
		this.number = number;
	}
	public String getName(){
		return this.name;
	}
	public int getNumber(){
		return this.number;
	}
	
	@Override
	public int compareTo(food o) {
		// TODO Auto-generated method stub
		int value1 = this.number;
		int value2 = o.number;
		if(value1<value2){
			return -1;
		}else{
			return 1;
		}
	}
}
public class ShoppingList {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int m = in.nextInt();
			int n = in.nextInt();
			ArrayList<Integer> values = new ArrayList<Integer>();
			for(int i = 0; i<m; i++){
				values.add(in.nextInt());
			}
			HashMap<String, Integer> shoplistmap = new HashMap<String,Integer>();
			for(int i = 0; i<n;i++){
				String key = in.next();
				if(shoplistmap.containsKey(key)){
					shoplistmap.put(key, (Integer)shoplistmap.get(key)+1);
				}else{
					shoplistmap.put(key, 1);
				}
			}
			ArrayList<Integer> shoplist = new ArrayList<Integer>();
			for(String key:shoplistmap.keySet()){
				shoplist.add(shoplistmap.get(key));
			}
			Collections.sort(shoplist);
			Collections.sort(values);
			int large=0;
			int small = 0;
			int k = shoplist.size();
			for(int i = 0; i<k;i++){
				large+= shoplist.get(k-i-1)*values.get(m-i-1);
				small += shoplist.get(k-i-1)*values.get(i);
			}
			System.out.println(small+" "+large);
		}
		
	}
}
