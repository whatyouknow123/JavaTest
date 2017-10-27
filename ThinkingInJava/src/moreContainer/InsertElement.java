package moreContainer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class InsertElement {
	public static void main(String[] args){
		ArrayList al = new ArrayList();
		LinkedList ll = new LinkedList();
		for(int i  = 0; i< 5;i++){
			al.add(i);
			ll.add(i+5);
		}
		ListIterator it = al.listIterator(al.size());
		int index = 0;
		while(it.hasPrevious()){			
			it.previous();
			it.add(ll.get(index));
			index++;
			it.previous();
		}
		System.out.println(al);
		
	}
}
