package javaIO;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;


class SimpleFilter implements FilenameFilter{
	private Pattern pattern;
	public static long nums = 0;
	public SimpleFilter(String args){
		pattern = Pattern.compile(args);
	}
	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		nums += dir.length();
		boolean result = pattern.matcher(name).matches();
		return result;
	}

	
}
//不知道为啥这个pattern不能识别出文件名，一直都是没有
//一直找不到的原因是正则表达式写错了
public class DirList {
	@SuppressWarnings("static-access")
	public static void main(String[] args){
		File file = new File("E:\\myeclipse\\data\\ThinkingInJava\\src\\moreContainer");
		String[] list;
		//要特别注意这里的正则表达式别写错了
		SimpleFilter s = new SimpleFilter("[a-zA-Z]*.java");
		list = file.list(s);
		for(String each:list){
			System.out.println(each);
		}
		System.out.println(s.nums);
	}
	
	
}
