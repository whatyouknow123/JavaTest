package probability;

import java.util.Random;
import java.util.Scanner;

class linknode{
	public int val;
	public int ptr;
	public int rank;
	linknode(int val, int ptr, int rank){
		this.val = val;
		this.ptr = ptr;
		this.rank = rank;
	}
}
public class Search {
	public static linknode[] list = new linknode[7];
	public static int head = 3;
	public static int n = 7;
	public static int search(int x, int i){
		int temp = 0;
		while(x>list[i].val){
			i = list[i].ptr;
			temp++;
		}
		return temp;
	}
	
	public static int A(int x){
		return search(x, head);
	}
	
	public static int D(int x){
		Random r = new Random();
		int i = r.nextInt(7);
		int y = list[i].val;
		if(x<y){
			return search(x, head);
		}else if(x>y){
			return search(x, list[i].ptr);
		}else{
			return 0;
		}
	}
	
	public static int B(int x){
		int i = head;
		int max = list[i].val;
		for(int j = 0; j<=Math.sqrt(1.0*n);j++){
			int y = list[j].val;
			if(y>max && y <= x){
				i = j;
				max = y;
			}
		}
		return search(x, i);
	}
	
	public static int C(int x){
		int i = head;
		int max = list[i].val;
		Random rand = new Random();
		int number = (int)Math.sqrt(1.0*n);
		int number2 = n -number;
		int r = rand.nextInt(number2);
		for(int j = r;j<=r+number;j++){
			int y = list[j].val;
			if(y>max && y <= x){
				i = j;
				max = y;
			}
		}
		return search(x, i);
	}
	
	public static void main(String[] args){
		
		linknode node1 = new linknode(2, 1, 2);
		linknode node2 = new linknode(3, 4, 3);
		linknode node3 = new linknode(13, 5, 6);
		linknode node4 = new linknode(1, 0, 1);
		linknode node5 = new linknode(5, 6, 4);
		linknode node6 = new linknode(21, -1, 7);
		linknode node7 = new linknode(8, 2, 5);
		list[0] = node1;
		list[1] = node2;
		list[2] = node3;
		list[3] = node4;
		list[4] = node5;
		list[5] = node6;
		list[6] = node7;
		Scanner ins = new Scanner(System.in);
		int x = ins.nextInt();
		int number1 = A(x);
		int number2 = B(x);
		int number3 = C(x);
		int number4 = D(x);
		System.out.println(number1);
		System.out.println(number2);
		System.out.println(number3);
		System.out.println(number4);
	}
}
