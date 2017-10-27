package middle;

public class SearchInsertPosition {
	public int searchInsert(int[] nums, int target){
		int i =0;
		while(i<nums.length){
			if(target == nums[i]){
				break;
			}else if(nums[i] > target){
				break;
			}else{
				i++;
			}
		}
		return i;
	}
	
	public static void main(String[] args){}
}
