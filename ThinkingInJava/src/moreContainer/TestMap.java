package moreContainer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class TestMap {
	public static void main(String[] args){
		HashMap hm = new HashMap();
		TreeMap tm = new TreeMap();
		LinkedHashMap lhm = new LinkedHashMap();
		hm.put("wuyanjing", 23);
		tm.put("wuyanjing", 23);
		lhm.put("wuyanjing", 23);
		System.out.println(hm);
		System.out.println(tm);
		System.out.println(lhm);
	}
}
