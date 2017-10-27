package middle;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumTwo {
	
	 public List<List<Integer>> combinationSum2(int[] candidates, int target) {
	        List<List<Integer>> list = new ArrayList<List<Integer>>();
	        Arrays.sort(candidates);
	        backTrack2(list, new ArrayList(), candidates, target, 0);
	        return list;
	    }

	private void backTrack(List<List<Integer>> list, ArrayList arrayList,
			int[] candidates, int target, int start) {
		// TODO Auto-generated method stub
		
		if(target < 0){
			return;
		}else if (target == 0){
			if(list.contains(arrayList) == false){
				list.add(new ArrayList(arrayList));
			}	
		}else{
			for(int i = start; i < candidates.length;i++){
				arrayList.add(candidates[i]);
				backTrack(list, arrayList, candidates, target-candidates[i], i+1);
				arrayList.remove(arrayList.size() - 1);
			}
		}
	}
	
	private void backTrack2(List<List<Integer>> list, ArrayList arrayList, int[] candidates, int target, int start){
		if(target < 0){
			return;
		}else if(target == 0){
			//we should new an ArrayList, because the arrayList will change later,
			//if we do not copy it's value, list will add []
			list.add(new ArrayList<Integer>(arrayList));
		}else{
			for(int i = start;i<candidates.length;i++){
				if(i > start && candidates[i] == candidates[i - 1]) continue;
				arrayList.add(candidates[i]);
				backTrack2(list, arrayList, candidates, target-candidates[i], i+1);
				arrayList.remove(arrayList.size() - 1);
			}
		}
	}
	
	public static void main(String[] args){
		CombinationSumTwo c = new CombinationSumTwo();
		int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
		List<List<Integer>> l = c.combinationSum2(candidates, 8);
		System.out.println(l);
	}
	 
}
