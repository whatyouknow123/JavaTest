package myArray;

class BerylliumSphere{
	private static long counter;
	private final long id = counter++;
	public String toString(){
		return "Sphere"+id;
	}
}
public class ReturnLengthArray {
	public static BerylliumSphere[] returnArray(int length){
		BerylliumSphere[] newArray = new BerylliumSphere[length];
		for(int i = 0;i<length;i++){
			newArray[i] = new BerylliumSphere();
		}
		return newArray;
	}
	public static void main(String[] args){
		BerylliumSphere[] ob = returnArray(2);
		for(int i = 0;i<2;i++){
			System.out.println(ob[i]);
		}
	}
}
