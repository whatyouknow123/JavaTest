package middle;
import java.util.*;
public class PermutationTwo {
	public List<List<Integer>> permuteUnique(int[] nums){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		Arrays.sort(nums);
		ArrayList addnums = new ArrayList();
		trackBack(nums, new ArrayList(), result, addnums);
		return result;
	}

	private void trackBack(int[] nums, ArrayList arrayList,
			List<List<Integer>> result, ArrayList addnums) {
		// TODO Auto-generated method stub
		if(arrayList.size()==nums.length && result.contains(arrayList)==false){
			result.add(new ArrayList(arrayList));
		}
		for(int i = 0; i<nums.length;i++){
//			if(i > 0 && nums[i] == nums[i-1]) continue;
			if(addnums.contains(i)) continue;
			arrayList.add(nums[i]);
			addnums.add(i);
			trackBack(nums, arrayList, result, addnums);
			arrayList.remove(arrayList.size() - 1);
			addnums.remove(addnums.size() - 1);
		}
	}
	
	public List<List<Integer>> permuteUniqueTwo(int[] nums){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		Arrays.sort(nums);
		trackBackTwo(nums, result, new ArrayList(), new boolean[nums.length]);
		
		return result;
	}
	
	private void trackBackTwo(int[] nums, List<List<Integer>> result,
			ArrayList arrayList, boolean[] use) {
		// TODO Auto-generated method stub
		if(arrayList.size() == nums.length){
			result.add(new ArrayList(arrayList));
		}else{
			for(int i = 0; i< nums.length;i++){
				if(use[i] || i > 0&&nums[i] == nums[i-1]&&use[i-1]==false) continue;
				use[i] = true;
				arrayList.add(nums[i]);
				trackBackTwo(nums, result, arrayList, use);
				arrayList.remove(arrayList.size() - 1);
				use[i] = false;
			}
		}
	}

	public static void main(String args[]){
		PermutationTwo p = new PermutationTwo();
		int[] nums = new int[]{1, -1, 1, 2, -1, 2, 2, -1};
		List<List<Integer>> list = p.permuteUniqueTwo(nums);
		System.out.println(list);
	}

}
