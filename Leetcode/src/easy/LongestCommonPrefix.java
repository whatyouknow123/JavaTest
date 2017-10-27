package easy;

public class LongestCommonPrefix {
	/*���س�����̵��ַ�����List�����ڵ�λ��*/
	private static int shortestStringLength(String[] strs){
		
		//�жϵ�ǰ��List���Ƿ����ַ�����û�еĻ�����-1�����򷵻ص�ǰlist�г�����̵��ַ������ڵ�λ��
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
		/*shortestStringLength�ķ���ֵ����-1��˵��strs��û���ַ��������Ϊ�գ�
		 * ����Ļ���������̵��ַ���������ıȽ��������ַ����Ƿ������ǰ����ַ�����ǰ׺���Ӷ����ϵ�����ǰ׺�ĳ��ȡ�
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
