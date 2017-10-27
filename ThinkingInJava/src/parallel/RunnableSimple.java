package parallel;

public class RunnableSimple implements Runnable{
	protected int count = 3;
	private static int taskcount = 0;
	private final int id = taskcount++;
	
	public String status(){
		return "#"+id+"("+(count>0?count:"listoff!")+") ";
	}
	
	public RunnableSimple(){
		System.out.println("you have start the thread");
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(count-->0){
			System.out.println(status());
			Thread.yield();
		}
	}
//	public static void main(String[] args){
//		for(int i = 0;i<5;i++){
//			new Thread(new RunnableSimple()).start();
//		
//		}
//		System.out.println("wait for listoff");
//	}
}
