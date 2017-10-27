package javaIO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TextFile {
	@SuppressWarnings("finally")
	public static Map<Character, Integer> read(String filename) throws IOException{
		HashMap<Character, Integer>  result = new HashMap<Character, Integer>();
		try{
			BufferedReader rfile = new BufferedReader(new FileReader(filename));	
			try{
				int s;
				while((s = rfile.read())!=-1){
					if(result.containsKey((char)s)){
						result.put((char)s, result.get((char)s)+1);
					}else{
						result.put((char)s, 1);
					}
				}
			}catch(Exception e){
				System.out.println("inner error");
			}finally{
				rfile.close();

			}
			
		}catch(Exception e){
			System.out.println("IOException");
		}
		return result;
	}
	
	public static void main(String[] args){
		Map<Character, Integer> result = null;
		try {
			result = read(".\\src\\javaIO\\BufferedInput.java");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Set<Character> keys = result.keySet();
		for(Character c:keys){
			System.out.println(c+":"+result.get(c)+"\n");
		}
	}
}
