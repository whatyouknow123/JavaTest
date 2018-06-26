package datastructure;

import java.util.Scanner;

/**
 * realize the data structure named max heap by using the array
 * 
 * author:wuyanjing
 * date:2018/5/4
 */
public class MyMaxHeap<T extends Comparable<T>> {
	
	// find the index of left children
	public static int left(int i){
		return (i+1)*2 -1;
	}
	
	// find the index of right children
	public static int right(int i){
		return (i+1)*2;
	}
	
	// find the index of parent
	public static int parent(int i){
		return (i-1)/2;
	}
	
	//keep the max heap structure
	public static void heapkeep(int[] a, int i, int heaplength){
		int l = left(i);
		int r = right(i);
		int largest = i;
		if(l<heaplength&&a[i]<a[l]){
			largest = l;
		}
		if(r<heaplength&&a[largest]<a[r]){
			largest = r;
		}
		if(largest!=i){
			int temp = a[largest];
			a[largest] = a[i];
			a[i] = temp;
			heapkeep(a, largest, heaplength);
		}
	}
	
	// create the heap
	public static int heapcreate(int[] a, int length){
		if(a.length<length){
			return -1;
		}else{
			int pr = parent(length-1);
			for(int i = pr;i>=0;i--){
				heapkeep(a, i, length);
			}
			return 0;
		}
	}
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			int[] a = new int[n];
			for(int i= 0; i<n;i++){
				a[i] = in.nextInt();
			}
			heapcreate(a, n);
			for(int i = 0; i<n; i++){
				System.out.println(a[i]);
			}
		}
	}
}
