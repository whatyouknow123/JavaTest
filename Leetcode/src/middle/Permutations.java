package middle;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public List<List<Integer>> permute(int[] nums){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int length = nums.length;
		trackback(nums, new ArrayList(),result);
		return result;
	}

	private void trackback(int[] nums, ArrayList tempList, List<List<Integer>> result) {
		// TODO Auto-generated method stub
		if(tempList.size() == nums.length){
			result.add(new ArrayList(tempList));
		}else{
			for(int i = 0; i < nums.length;i++){
				if(tempList.contains(nums[i]))
					continue;
				tempList.add(nums[i]);
				trackback(nums, tempList, result);
				tempList.remove(tempList.size() - 1);
				
			}
		}
		
	}
	
	public static void main(String[] args){
		Permutations p = new Permutations();
		int[] nums = new int[]{1,2,3};
		List<List<Integer>> result = p.permute(nums);
		System.out.println(result);
	}
	
	
}
