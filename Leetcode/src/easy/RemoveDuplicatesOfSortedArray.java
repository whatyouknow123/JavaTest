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
					//�ҵ����в�һ������
					temp = nums[i];
					length++;
					//�����в�һ������������Ӧ��λ��
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
