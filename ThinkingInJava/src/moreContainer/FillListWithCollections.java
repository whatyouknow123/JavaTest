package moreContainer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FillListWithCollections {
	public static void main(String[] args){
		List lists = new ArrayList();
		for(int i= 0;i<10;i++){
			lists.add(i);
		}
		int k = 0;
		Collections.sort(lists);
		while(k<5){
			System.out.println(lists);
			Collections.shuffle(lists);
			
			k++;
		}
	}
}
