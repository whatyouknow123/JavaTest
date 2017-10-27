package easy.array;

public class RemoveElement {
	 public int removeElement(int[] nums, int val) {
	        int length = 0;
	        int pos = 0;
	        while(pos < nums.length){
	        	if(nums[pos] == val){
	        		pos++;
	        	}else{

	        		nums[length] = nums[pos];
	        		pos++;
	        		length++;
	        	}
	        }
	        return length;
	    }
	 public static void main(String[] args){
		 RemoveElement re = new RemoveElement();
		 int[] nums = {3,2,2,3};
		 int val = 3;
		 int returnnum = re.removeElement(nums, val);
		 System.out.println(returnnum);
	 }
}
