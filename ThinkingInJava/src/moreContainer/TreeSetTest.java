package moreContainer;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

class SetType{
	String i;
	SetType(String i){
		this.i = i;
	}
	public boolean equals(Object j){
		return j instanceof SetType && (i.equals(((SetType)j).i));
	}
	
	public String toString(){
		return i;
	}
}


class MySortedSet extends SetType implements Comparable<SetType>{
	MySortedSet(String i){
		super(i);
	}
	
	public int compareTo(SetType o){
		return o.i.length() < i.length()?-1:(o.i.length() == i.length()?0:1);
	}
}
public class TreeSetTest {
	public static void main(String[] args){
		SortedSet<MySortedSet> ss = new TreeSet<MySortedSet>();
		ss.add(new MySortedSet("hh"));
		ss.add(new MySortedSet("a"));
		ss.add(new MySortedSet("one"));
	
		System.out.println(ss);
			
	}
	
}
