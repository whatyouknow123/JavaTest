package moreContainer;

import java.util.PriorityQueue;
import java.util.Random;

public class RandomPriority {
	static class RandItem implements Comparable<RandItem>{
		int randnum;
		Random rand = new Random();
		RandItem(){
			this.randnum = rand.nextInt(100);
			
		}
		@Override
		public int compareTo(RandItem o) {
			// TODO Auto-generated method stub
			return o.randnum<randnum?1:(o.randnum == randnum?0:-1);
		}
		
		public String toString(){
			return Integer.toString(randnum);
		}
	}
	public static void main(String[] args){
		PriorityQueue<RandItem> pq = new PriorityQueue<RandItem>();
		for(int i = 0;i<=5;i++){
			pq.add(new RandItem());
		}
		while(pq.peek()!=null){
			System.out.println(pq.poll());
		}
	}
}
