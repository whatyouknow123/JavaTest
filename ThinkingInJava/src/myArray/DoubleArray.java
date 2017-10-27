package myArray;

import java.util.*;
public class DoubleArray {
	private double[][] returnDoubleArray(int length, int low, int high){
		double[][] result = new double[length][length];
		Random rand = new Random(47);
		for(int i = 0;i<result.length;i++){
			for(int j = 0;j< result.length;j++){
				double randchoose = rand.nextDouble();
				result[i][j] = (high - low)*randchoose + low;
			}
		}
		return result;
	}
	
	private BerylliumSphere[][] returnBerry(int row , int col){
		BerylliumSphere[][] result = new BerylliumSphere[row][col];
		for(int i = 0;i<row;i++){
			for(int j = 0;j <col;j++){
				result[i][j] = new BerylliumSphere();
			}
		}
		return result;
	}
	
	private void printNum(BerylliumSphere[][] nums){
		for(int i = 0;i<nums.length;i++){
			for(int j = 0;j<nums[i].length;j++){
				System.out.print(nums[i][j] + " ");
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		DoubleArray d = new DoubleArray();
		for(int i = 2; i<4;i++){
			d.printNum(d.returnBerry(i,i));
		}
	}
}
