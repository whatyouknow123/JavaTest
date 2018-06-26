package jingdong;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
class Candy implements Comparable<Candy>{
	private int number;
	private int weight;
	private int code;
	public void setNumber(int number){
		this.number = number;
	}
	public void setWeight(int weight){
		this.weight = weight;
	}
	public void setCode(int code){
		this.code = code;
	}
	public int getNumber(){
		return this.number;
	}
	public int getWeight(){
		return this.weight;
	}
	public int getCode(){
		return this.code;
	}

	@Override
	public int compareTo(Candy o) {
		// TODO Auto-generated method stub
		double value1 = (double)weight/number;
		double value2 = (double)o.weight/o.number;
		if(value1<value2){
			return 1;
		}else if(value1>value2){
			return -1;
		}else{
			if(number<o.number){
				return 1;
			}else{
				return -1;
			}
		}
	}
	
}
public class BuyCandy {
	
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			int v = in.nextInt();
			int min = 2;
			ArrayList<Candy> candyList = new ArrayList<Candy>();
			for(int i = 0;i<n;i++){
				Candy candy = new Candy();
				candy.setCode(i+1);
				candy.setNumber(in.nextInt());
				candy.setWeight(in.nextInt());
				candyList.add(candy);
				if(candy.getNumber()<min){
					min = candy.getNumber();
				}
			}
			if(v<min){
				System.out.println(0);
				System.out.println("No");
			}else{
				Collections.sort(candyList);
				int temp = 0;
				int total = 0;
				ArrayList<Integer> result = new ArrayList<Integer>();
				ArrayList<Candy> count1 = new ArrayList<Candy>();
				ArrayList<Candy> count2 = new ArrayList<Candy>();
				for(int i = 0;i<candyList.size();i++){
					Candy tempCandy = candyList.get(i);
					if(tempCandy.getNumber()==1){
						count1.add(tempCandy);
					}else{
						count2.add(tempCandy);
					}
				}
				int a1count = 0;
				int a2count = 0;
				for(int i= 0; i<n;i++){
					Candy tempCandy = candyList.get(i);
					if((temp+tempCandy.getNumber())<v){
						if(tempCandy.getNumber()==1){
							a1count++;
						}else{
							a2count++;
						}
						temp+=tempCandy.getNumber();
						total += tempCandy.getWeight();
						result.add(tempCandy.getCode());
					}else if((temp+tempCandy.getNumber())>v){
						if(a1count==0){
							if(count1.size()>0){
								temp+=1;
								total+=count1.get(0).getWeight();
								result.add(count1.get(0).getCode());
							}
							
						}else{
							if(a1count<count1.size()){
								if((count1.get(a1count).getWeight()+count1.get(a1count-1).getWeight())<count2.get(a2count).getWeight()){
									Iterator<Integer> iter = result.iterator();
									while(iter.hasNext()){
										if(iter.next().equals(count1.get(a1count-1).getCode())){
											iter.remove();
										}
									}
//									result.remove(count1.get(a1count-1).getCode());
									result.add(count2.get(a2count).getCode());
									temp += 1;
									total = total - count1.get(a1count-1).getWeight()+count2.get(a2count).getWeight();
								}else{
									result.add(count1.get(a1count).getCode());
									temp += 1;
									total = total+count1.get(a1count).getWeight();
	
								}
							}else{
								if(a2count<count2.size()){
									if(count2.get(a2count).getWeight()>count1.get(a1count-1).getWeight()){
										Iterator<Integer> iter = result.iterator();
										while(iter.hasNext()){
											if(iter.next().equals(count1.get(a1count-1).getCode())){
												iter.remove();
											}
										}
										result.add(count2.get(a2count).getCode());
										temp += 1;
										total = total - count1.get(a1count-1).getWeight()+count2.get(a2count).getWeight();
									}
								}
							}
						}
						break;
					}else{
						temp+=tempCandy.getNumber();
						total += tempCandy.getWeight();
						result.add(tempCandy.getCode());
						break;
					}
				}
				Collections.sort(result);
				System.out.println(total);
				if(total ==0){
					System.out.println("No");
				}else{
					for(int i =0; i<result.size();i++){
						System.out.print(result.get(i));
						System.out.print(" ");
					}
					System.out.println();
				}
				
			}
		}
	}
}
