package middle;

import java.util.Arrays;

public class NextPermutation {
	public void nextPermutation(int[] nums){
		if(nums.length >= 2){
			int position = nums.length - 1;
			int i = position - 1;
			while(i>=0){
				if(nums[i]>= nums[i+1]){
					i--;
				}else{
					break;
				}
			}
			if(i == -1){
				for(int j = 0; j<=((nums.length - 1)/2);j++){
					int num = nums[nums.length - 1- j];
					nums[nums.length -1 -j] = nums[j];
					nums[j] = num;
				}
			}else{
				for(int j = position; j >i; j--){
					if(nums[j] > nums[i]){
						int num = nums[j];
						nums[j] = nums[i];
						nums[i] = num;
						break;
					}
				}
				for(int j = i+1; j<=(i+1+nums.length-1)/2;j++){
					int num = nums[nums.length - 1 + i +1 -j];
					nums[nums.length -1 +i+1-j] = nums[j];
					nums[j] = num;
				}
			}
			
		}
	}
	
	public static void main(String[] args){
		NextPermutation n = new NextPermutation();
		int[] nums = new int[]{3, 2, 1};
		n.nextPermutation(nums);
		for(int i = 0;i< nums.length ;i++){
			System.out.println(nums[i]);
		}
	}
}
