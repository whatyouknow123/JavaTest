package middle;

import java.util.ArrayList;

public class SearchRotated {
	public boolean search(int[] nums, int target){
		int low = 0;
		int high = nums.length-1;
		if(nums[high] == nums[low]&&nums.length>2){
			for(int i = high-1;i>=low;i--){
				if(nums[i] == nums[high]){
					high--;
				}
			}
		}
		while(low <= high){
			int middle = (low+high)/2;
			if(nums[middle] == target){
				return true;
			}else if(nums[middle] >=nums[low]){
				if(target>=nums[low] && target<nums[middle]){
					for(int i = middle-1;i>=low;i--){
						if(nums[i] == nums[middle]){
							middle--;
						}else{
							break;
						}
					}
					high = middle -1; 
				}else{
					for(int i = middle+1;i<=high;i++){
						if(nums[i] == nums[middle]){
							middle++;
						}else{
							break;
						}
					}
					low = middle + 1;
				}
			}else{
				if(target>nums[middle]&&target<=nums[high]){
					for(int i =middle+1;i<=high;i++){
						if(nums[i] == nums[middle]){
							middle++;
						}else{
							break;
						}
					
					}
					low = middle +1;
				}else{
					for(int i = middle-1;i>=low;i--){
						if(nums[i] == nums[middle]){
							middle--;
						}else{
							break;
						}
						
					}
					high = middle - 1;
				}
			}
		}
		return false;
	}
	
	public boolean search2(int[] nums, int target){
		if(nums.length == 0){
			return false;
		}
		int low = 0;
		int high = nums.length - 1;
		while(low < high){
			int middle = (low +high)/2;
			if(nums[middle] == target){
				return true;
			}else{
				if(nums[middle] < nums[high]){
					if(target > nums[middle] && target <= nums[high]){
						low = middle + 1;
					}else{
						high = middle - 1;
					}
				}else if(nums[middle] > nums[high]){
					if(target >= nums[low] & target < nums[middle]){
						high = middle -1;
					}else{
						low = middle +1;
					}
				}else{
					high--;
				}
			}
		}
		return nums[low]==target;
	}
	public static void main(String[] args){
		SearchRotated sr = new SearchRotated();
		int[] nums= new int[]{1,1,1,3,1};
		int target = 3;
		boolean result1 = sr.search2(nums, target);
		System.out.println("the target1 is "+result1);
		target = 4;
		result1 = sr.search2(nums, target);
		System.out.println("the target2 is "+result1);
	}
}
