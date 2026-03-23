package Day7.Threads;

public class Main {
	public static void main(String[] args) {
		Thread thread=new MyThread();
		thread.start();
		
		
		//using runnable
		Thread task=new Thread(new MyTask());
		task.start();
	}
}
