package myArray;

import java.util.Arrays;

public class ArrayCopy {
	public static void main(String[] args){
		BerylliumSphere[] result = new BerylliumSphere[10];
		Arrays.fill(result, new BerylliumSphere());
		BerylliumSphere[] result2 = new BerylliumSphere[15];
		Arrays.fill(result2, new BerylliumSphere());
		System.arraycopy(result, 0, result2, 0, result.length);
		System.out.println(Arrays.toString(result2));
	}
}
