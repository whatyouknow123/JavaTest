package parallel;
import java.util.concurrent.*;

public class ThreadExecutor {
	public static void exe1(){
		ExecutorService exe = Executors.newCachedThreadPool();
		for(int i = 0;i<5;i++){
			exe.execute(new RunnableSimple());
		}
		exe.shutdown();
	}
	
	public static void exe2(){
		ExecutorService exe = Executors.newFixedThreadPool(5);
		for(int i=0;i<5;i++){
			exe.execute(new RunnableSimple());
		}
		exe.shutdown();
	}
	
	public static void exe3(){
		ExecutorService exe3 = Executors.newSingleThreadExecutor();
		for(int i  = 0;i<5;i++){
			exe3.execute(new RunnableSimple());
		}
		exe3.shutdown();
	}
	public static void main(String[] args){
		exe1();
	}
}
