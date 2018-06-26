package jingdong;

import java.util.Scanner;

public class ForExam {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int d = in.nextInt();
			int sumtime = in.nextInt();
			int[] imintime = new int[d+1];
			int[] imin = new int[d+1];
			int[] imax = new int[d+1];
			int min=0;
			int max = 0;
			for(int i= 0; i<d;i++){
				imin[i] = in.nextInt();
				imax[i] = in.nextInt();
				min += imin[i];
				max += imax[i];
			}
			if(sumtime>=min&&sumtime<=max){
				int[] result = imin;
				int temp = min;
				for(int i= 0; i<d;i++){
					if(temp<sumtime){
						int imaxvalue = imax[i] - imin[i];
						int needvalue = sumtime - temp;
						if(imaxvalue <= needvalue){
							result[i] = imax[i];
							temp = temp+imaxvalue;
						}else{
							result[i] = imin[i] + needvalue;
							temp = temp+needvalue;
						}
					}
				}
				System.out.println("Yes");
				for(int i=0;i<d;i++){
					System.out.print(result[i]);
					System.out.print(" ");
				}
				System.out.println();
			}else{
				System.out.println("No");
			}
		}
	}
}
