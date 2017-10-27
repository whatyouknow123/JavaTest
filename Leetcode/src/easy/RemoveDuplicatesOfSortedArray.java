package easy;

public class RemoveDuplicatesOfSortedArray {
	
	public int removeDuplicates(int[] nums){
		//if the nums is empty return length = 0
		int length = 0;
		if(nums.length>0){
			int temp = nums[0];
			length=1;
			for(int i = 0; i<nums.length;i++){
				if(temp != nums[i]){
					//找到所有不一样的数
					temp = nums[i];
					length++;
					//将所有不一样的数放在相应的位置
					nums[length - 1] = temp;
				}
			}
		}
		
		return length;
	}
	
	public static void main(String[] args){
		RemoveDuplicatesOfSortedArray a = new RemoveDuplicatesOfSortedArray();
		int[] nums = new int[]{1,1,2};
		int length = a.removeDuplicates(nums);
		System.out.println(length);
	}

}
