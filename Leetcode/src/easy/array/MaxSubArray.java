package easy.array;

import java.util.Arrays;

public class MaxSubArray {
	public int maxSubArray(int[] nums){
		int maxsofar = nums[0];
		int maxtotal = nums[0];
		for(int i = 1; i< nums.length;i++){
			maxsofar = Math.max(maxsofar+nums[i], nums[i]);
			maxtotal = Math.max(maxtotal, maxsofar);
		}
		return maxtotal;
	}
	
	public static void main(String[] args){
		int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
		MaxSubArray max = new MaxSubArray();
		int num = max.maxSubArray(nums);
		System.out.println(num);
	}
}
