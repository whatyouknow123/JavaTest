package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	
	public List<List<Integer>> combinationSum(int[] candidates, int target){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		backtrack(list, new ArrayList(),candidates,  target, 0);
		System.out.println(list);
		return list;
	}
	
	private void backtrack(List<List<Integer>> list, ArrayList arrayList,
			int[] candidates, int target, int start) {
		// TODO Auto-generated method stub
		if(target < 0){
			return;
		}else if(target == 0){
			list.add(new ArrayList<Integer>(arrayList));
		}else{
			for(int i = start;i<candidates.length;i++){
				arrayList.add(candidates[i]);
				backtrack(list, arrayList, candidates, target-candidates[i], i);
				arrayList.remove(arrayList.size() - 1);
			}
		}
	}
	
	public static void main(String[] args){
		CombinationSum sum = new CombinationSum();
		int[] candidates = new int[]{2, 3,5 ,7};
		sum.combinationSum(candidates, 7);
	}
}
