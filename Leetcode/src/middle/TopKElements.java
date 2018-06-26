package middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKElements {
	public static List<Integer> topKFrequent(int[] nums, int k){
	 	Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
			for(int n :nums){
				if(hashMap.containsKey(n)){
					hashMap.put(n, hashMap.get(n)+1);
				}
				else{
					hashMap.put(n, 1);
				}
				
			}
			
			List<Integer>[] record = new List[nums.length+1];
			for(int n :hashMap.keySet()){
				int frequent = hashMap.get(n);
				if(record[frequent]==null){
					record[frequent] = new ArrayList<Integer>();
					record[frequent].add(n);
					
				}else{
					record[frequent].add(n);
				}
			}
			
			List<Integer> result = new ArrayList<Integer>();
			for(int i = record.length-1; i>=0&&result.size()<k;i--){
				if(record[i] != null){
					result.addAll(record[i]);
				}
			}
			
			return result.subList(0, k);
	}
	
	public static void main(String[] args){
		TopKElements top = new TopKElements();
		int[] nums = {1,1,1,1,2,2,2};
		int k = 1;
		List<Integer> result =top.topKFrequent(nums, k);
		for(int n:result){
			System.out.println(n);
		}
	}
}
