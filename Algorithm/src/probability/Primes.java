package probability;

import java.util.ArrayList;
import java.util.Random;

public class Primes {
	
	Random rand = new Random();
	public ArrayList printPrimesSimple(){
		ArrayList lists = new ArrayList();
		for(int j = 101; j<10000;j++){
			int flag = 1;
			for(int i=2; i<=(int)Math.sqrt(j);i++){
				if(j%i==0){
					flag = 0;
					break;
				}
			}
			if(flag==1){
				lists.add(j);
			}
		}
		return lists;
	}
	public ArrayList printPrimes(){
		int n = 101;
		ArrayList lists = new ArrayList();
		do{
			if(repeatMillRab(n, (int)(Math.log(n)/Math.log(2)))==true){
				lists.add(n);
			}
			n = n+2;
		}while(n<10000);
		return lists;
	}
	
	public boolean repeatMillRab(int n, int b){
		for(int i = 1; i<=b; i++){
			if(millRob(n)==false){
				return false;
			}
		}
		return true;
	}
	
	public boolean millRob(int n){
		int a = rand.nextInt(n);
		a = 2 + (a+1)*(n-2-2)/n;
		return Btest(a, n);
	}
	
	public boolean Btest(int a, int n){
		int s = 0;
		int t = n-1;
		do{
			s++;
			t /= 2;
		}while(t%2!=1);
		
		int x = modularExponent(a, t, n);
		if(x==1||x==n-1){
			return true;
		}
		for(int i= 1; i<=s-1;i++){
			x = (x*x)%n;
			if(x==n-1){
				return true;
			}
		}
		return false;
	}
	
	public int modularExponent(int a, int t, int n){
		int s = 1;
		while(t>0){
			if(odd(t)){
				s = (s*a)%n;
			}
			a = (a*a)%n;
			t = t/2;
		}
		return s;
	}
	
	public boolean odd(int t){
		if(t%2==0){
			return false;
		}else{
			return true;
		}
	}
	
	public static void main(String[] args){
		Primes p = new Primes();
		ArrayList temp1 = new ArrayList();
		ArrayList temp2 = new ArrayList();
		temp2 = p.printPrimesSimple();
		long allcorrect = 0;
		long averagenum = 0;
		int k = 1000;
		while(k>0){
			temp1.clear();
			temp1 = p.printPrimes();
			int correct = 0;
			for(int i = 0;i<temp1.size();i++){
				if(temp2.contains(temp1.get(i))){
					correct++;
				}
			}
			allcorrect += correct;
			averagenum += temp1.size();
			k--;
		}
		System.out.println("the size of difinite algorithm "+temp2.size());
		System.out.println("the average size of propablity algorithm "+(averagenum/1000));
		double correctRate = (double)allcorrect/(temp2.size()*1000);
		System.out.println("the error rate is "+(1.0 - correctRate));
	}
}
