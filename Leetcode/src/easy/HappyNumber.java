package easy;

import java.util.ArrayList;
import java.util.List;

public class HappyNumber {
	public int value(List<Integer> nums){
		int k = 0;
		for(int i = 0; i<nums.size(); i++){
			k += nums.get(i)*nums.get(i) ;
		}
		return k;
	}
	public List<Integer> getnums(int n){
		List<Integer> nums = new ArrayList<Integer>();
		for(int i = n; i>0;){
			nums.add(i%10);
			i = i/10;
		}
		return nums;
	}
	public boolean isHappy(int n){
		List<Integer> nums = getnums(n);
		int tempvalue = value(nums);
		int loop = 0;
		while(tempvalue!=1 && loop<=10000){
			nums = getnums(tempvalue);
			tempvalue = value(nums);
			loop++;
		}
		if(loop>10000){
			return false;
		}else{
			return true;
		}
	}
	public static void main(String args[]){
		HappyNumber happy = new HappyNumber();
		int n = 1;
		boolean value = happy.isHappy(n);
		System.out.println(value);
	}
}
