package moreContainer;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class FilSetWithSameElement {
	public static void main(String[] args){
		Set sets = new HashSet();
		Set sets2 = new LinkedHashSet();
		Set sets3 = new TreeSet();
		for(int i = 0;i<5;i++){
			sets.add(1);
			sets2.add(2);
			sets3.add(3);
		}
		System.out.println(sets);
		System.out.println(sets2);
		System.out.println(sets3);
	}
}
