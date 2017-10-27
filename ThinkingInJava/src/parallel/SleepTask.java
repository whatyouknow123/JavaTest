package parallel;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepTask extends RunnableSimple{
	private Random rand = new Random();
	public void run(){
		try{
			while(count-->0){
				int randnum = rand.nextInt(10);
				TimeUnit.SECONDS.sleep(randnum);
				System.out.println(status()+" sleep "+randnum);
				
			}
		}catch(Exception e){
			System.out.println("interpretede");
		}
	}
	
	public static void main(String[] args){
		ExecutorService exe = Executors.newCachedThreadPool();
		for(int i = 0; i<5;i++){
			exe.execute(new SleepTask());
		}
		exe.shutdown();
	}
}
