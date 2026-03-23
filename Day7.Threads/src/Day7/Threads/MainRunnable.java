package Day7.Threads;

public class MainRunnable {
	public static void main(String[] args)  throws InterruptedException{
		Thread thread = new MyThread();
		thread.start();
		thread.join();
		System.out.println("main");
		//thread.sleep(2000);
		
		//using runnable
		Thread task=new Thread(new MyTask());
		task.start();
	}

}
