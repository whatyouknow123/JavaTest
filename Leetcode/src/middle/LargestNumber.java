package middle;

import java.util.Arrays;
import java.util.Comparator;


public class LargestNumber {
	public String largestNumber(int[] nums){
		String[] resource = new String[nums.length];
		for(int i = 0; i<nums.length; i++){
			resource[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(resource, new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				String a1 = o1+o2;
				String a2 = o2+o1;
				return a2.compareTo(a1);
			}
			
		});
		if(resource[0].charAt(0) == '0'){
			return String.valueOf('0'); 
		}
		StringBuilder result = new StringBuilder();
		
		for(int i = 0; i<nums.length; i++){
			result.append(resource[i]);
		}
		
		return result.toString();
	}
	
	public static void main(String[] args){
		LargestNumber large = new LargestNumber();
		int[] nums = {0, 0};
		String s = large.largestNumber(nums);
		System.out.println(s);
	}
}
