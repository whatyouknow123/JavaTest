package javaIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class OSExcute{
	public static void command(String commands) throws IOException{
		boolean err = false;
		try{
			Process p = new ProcessBuilder(commands.split(" ")).start();
			BufferedReader results = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String s;
			ArrayList array = new ArrayList();
			while((s = results.readLine())!= null){
				array.add(s);
			}
			BufferedReader errors = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			ArrayList error = new ArrayList();
			while((s = errors.readLine())!=null){
				error.add(s);
				err = true;
			}
			System.out.println(array);
			System.out.println(error);
			
		}catch(Exception e){
			System.out.println("The IO Exception");
			if(!commands.startsWith("CMD/C "+commands)){
				command("CMD/C "+commands);
			}else{
				throw new RuntimeException();
			}
		}finally{
			
		}
		if(err){
			throw new RuntimeException();
		}
	}
	
}

//it doesn't work because it can not find the ReadLine.java 
//i don't know why
public class ProcessController {
	public static void main(String[] args) throws IOException{
		OSExcute         .command("javap ReadLine");
	}
}
