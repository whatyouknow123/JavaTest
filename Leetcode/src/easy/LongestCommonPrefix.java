package easy;

public class LongestCommonPrefix {
	/*返回长度最短的字符串在List中所在的位置*/
	private static int shortestStringLength(String[] strs){
		
		//判断当前的List中是否有字符串，没有的话返回-1，否则返回当前list中长度最短的字符串所在的位置
		if(strs.length == 0){
			return -1;
		}else{
			int result = strs[0].length();
			int record = 0;
			for(int i = 1; i<strs.length;i++){
				if(result>strs[i].length()){
					result = strs[i].length();
					record = i;
				}
			}
			return record;
		}
		
	}
	
	public static String longestCommonPrefix(String[] strs){
		String result = "";
		int m = shortestStringLength(strs);
		/*shortestStringLength的返回值等于-1，说明strs中没有字符串，结果为空；
		 * 否则的话，利用最短的字符串，逐个的比较其他的字符串是否包含当前最短字符串的前缀。从而不断地增加前缀的长度。
		*/
		if(m == -1){
			return result;
		}else{
			int n = strs.length;
			for(int i = 0;i<strs[m].length();i++){
				char a = strs[m].charAt(i);
				for(int j = 0; j< n;j++){
					if(a != strs[j].charAt(i)){
						return result;
					}
				}
				result = result+a;
			}
			return result;
		}
		
	}
	
	public static void main(String[] args){
		String[] strs = new String[]{"ac","ac","a","a"};
		String result = longestCommonPrefix(strs);
		System.out.println(result);
	}
}
