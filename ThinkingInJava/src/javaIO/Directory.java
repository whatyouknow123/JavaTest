package javaIO;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class Directory {
	static long size = 0;
	public static File[] local(File dir, final String regex){
		return dir.listFiles(new FilenameFilter(){
			private Pattern pattern = Pattern.compile(regex);
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return pattern.matcher(new File(name).getName()).matches();
			}
		});
	}
	
	public static File[] local(String dir, final String regex){
		return local(new File(dir), regex);
	}
	
	public static class TreeInfo implements Iterable<File>{
		
		public List<File> files = new ArrayList<File>();
		public List<File> dirs = new ArrayList<File>();
		
		
		@Override
		public Iterator<File> iterator() {
			// TODO Auto-generated method stub
			return files.iterator();
		}
		
		void addAll(TreeInfo other){
			files.addAll(other.files);
			dirs.addAll(other.dirs);
		}
		
		public String toString(){
			return "dirs: "+ PPrint.pformat(dirs) + "\n\nfiles: " + PPrint.pformat(files);
		}
		
		
	}
	
	public static TreeInfo recurseDir(File start, String regex){
		TreeInfo treeinfo = new TreeInfo();
		for(File item:start.listFiles()){
			if(item.isDirectory()){
				treeinfo.dirs.add(item);
				treeinfo.addAll(recurseDir(item, regex));
			}else{
				if(item.getName().matches(regex)){
					size += item.length();
					treeinfo.files.add(item);
				}
			}
		}
		return treeinfo;
	}
	
	public static TreeInfo walk(String Start, String regex){
		return recurseDir(new File(Start), regex);
	}
	
	public static TreeInfo walk(File Start, String regex){
		return recurseDir(Start, regex);
	}
	
	public static TreeInfo walk(File Start){
		return recurseDir(Start, ".*");
	}
	
	public static TreeInfo walk(String Start){
		return recurseDir(new File(Start), ".*");
	}
	
	public static void main(String[] args){
		System.out.println(walk("E:\\myeclipse\\data\\ThinkingInJava\\src\\moreContainer"));
		System.out.println(size);
	}
}

class PPrint{
	public static String pformat(Collection<?> c){
		if(c.size() == 0){
			return "[]";
		}else{
			StringBuilder s = new StringBuilder();
			s.append("[");
			for(Object item : c){
				if(c.size() != 1){
					s.append("\n ");
				s.append(item);
				}
			}
			if(c.size() != 1){
				s.append("\n");
			}
			s.append("]");
			return s.toString();
		}
	}
	
	public static void pprint(Collection<?> c){
		System.out.println(pformat(c));
	}
	
	public static void pprint(Object[] c){
		System.out.println(pformat(Arrays.asList(c)));
	}
}
