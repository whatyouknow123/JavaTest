package easy;

public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
		int position = s.length() - 1;
        if(s.isEmpty()){
            return 0;
        }else{
        	while(position >= 0){
        		if(s.charAt(position) == ' '){
        			position--;
        		}else{
        			break;
        		}
        		
        	}
        	if(position == -1){
        		return 0;
        	}else{
        		 for(int i = position;i>=0;){
                     if(s.charAt(i) != ' ' ){
                         i--;
                     }else{
                         return position-i;
                     }
                 }
        	}
           
        }
		return position+1;
    }	
	
	public static void main(String[] args){
		LengthOfLastWord l = new LengthOfLastWord();
		String s =" ";
		System.out.println(l.lengthOfLastWord(s));
	}
}
