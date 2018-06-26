package jingdong;

import java.util.Scanner;

public class SecurityCity {
	public static int maxValue(int[] max, int length){
		int maxresult = 0;
		for(int i=0;i<length;i++){
			if(maxresult<max[i]){
				maxresult = max[i];
			}
		}
		return maxresult;
	}
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			int[] numbers = new int[n+1];
			for(int i= 0;i<n;i++){
				numbers[i] = in.nextInt();
			}
			int result = 0;
			for(int i =0;i<n-1;i++){
//				int top;
//				if(i==0){
//					top = n-1;
//				}else{
//					top = n;
//				}
				for(int j = i+1;j<n;j++){
					int[] max1 = new int[n+1];
					int[] max2 = new int[n+1];
					for(int k=0;k<n;k++){
						max2[k]=0;
					}
					System.arraycopy(numbers, 0, max1, 0, n);
					System.arraycopy(numbers, i+1, max2, 0, j-i-1);
					for(int k=i;k<=j;k++){
						max1[k]=0;                                                                                                        
					}
					
					int maxresult1 = maxValue(max1, n);
					int maxresult2 = maxValue(max2,j-i);
//					int tempresult = Math.max(numbers[i], numbers[j]);
					if(maxresult1 <=numbers[i]&&maxresult1<=numbers[j]){
						result++;
						continue;
					}
					if(maxresult2 <=numbers[i]&&maxresult2<=numbers[j]){
						result++;
					}
					
					
				}
			}
			System.out.println(result);
		}
	}
}
