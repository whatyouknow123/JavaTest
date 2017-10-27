package probability;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class QueenLv {
	
	long cal = 0;
	boolean record = false;
	public int[] obstinate(int n , int stepvegas){
		int[] trysed = new int[n+1];
		boolean success = false;
		
		do{
			trysed = queenLv(n, stepvegas, success);
			
		}while(record==false);
		return trysed;
	}
	
	public boolean backtrace(int k, HashSet col, HashSet diag45, HashSet diag135, boolean success, int n, int[] trys){
		boolean flag = true;
		Stack<Integer> stack = new Stack<Integer>();
		int i = k+1;
		int j = 1;
		int m = 0;
		while(i<=n){
			for(m = j;m<=n;m++){
				if(col.contains(m)==false && diag45.contains(m-i)==false && diag135.contains(m+i)==false){
					break;
				}
			}
			if(m<=n){
				col.add(m);
				diag45.add(m-i);
				diag135.add(m+i);
				stack.push(m);
				trys[i]=m;
				cal++;
				i++;
				j = 1;
			}else{
				if(stack.isEmpty() == false){
					int value = stack.pop();
					i--;
					trys[i]=0;
					cal++;
					col.remove(value);
					diag45.remove(value-i);
					diag135.remove(value+i);
					j = value+1; 
				}else{
					flag = false;
					break;
				}
			}
		}
		return flag;
	}
	public int[] queenLv(int n, int stepvegas, boolean success){
		HashSet col = new HashSet();
		HashSet diag45 = new HashSet();
		HashSet diag135 = new HashSet();
		Random rand = new Random();
		boolean flag = true;
		int[] trys = new int[n+1];
		int k = 0;
		int j = 0;
		int nb = 0;
		do{
			nb = 0;
			for(int i = 1; i<=n; i++){
				if(col.contains(i)==false && diag45.contains(i-k-1)==false && diag135.contains(i+k+1)==false){
					nb++;
					if((rand.nextInt(nb)+1)==1){
						j = i;
					}
				}
			}
			if(nb > 0){
				k++;
				trys[k] = j;
				cal++;
				col.add(j);
				diag45.add(j-k);
				diag135.add(j+k);	
			}
		}while(nb!=0&&k!=stepvegas);
		if(nb>0){
			flag = backtrace(k, col, diag45, diag135, success, n, trys);
			success = flag;
			record = flag;
			return trys;
		}else{
			success = false;
			record = false;
			return new int[n];
		}
	}
	
	public static void main(String[] args){
		int n;
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		int stepvegas;
		long[][] recordarray = new long[10][n];
		for(int j = 0; j<10;j++){
			for(int i = 1; i <=n;i++){
				stepvegas = i;
				int[] trys = new int[n+1];
				QueenLv q = new QueenLv();
				trys = q.obstinate(n, stepvegas);
//				for(int j = 1;j<=n;j++){
//					System.out.print(trys[j]+" ");
//				}
//				System.out.println();
//				System.out.println(i+"  "+q.cal);
				recordarray[j][i-1]=q.cal;
			}
		}
		for(int i = 0;i<n;i++){
			long temp = 0;
			for(int j = 0;j<10;j++){
				temp += recordarray[j][i];
			}
			temp/=10;
			System.out.println(temp);
		}
		
		
	}
}
