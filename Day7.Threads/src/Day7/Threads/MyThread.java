package Day7.Threads;

public class MyThread extends Thread {
	public void run() {
	try {
		sleep(2000);
	}
	catch(InterruptedException e)
	{
		e.printStackTrace();
	}

	System.out.println("worker thread is running");
	}
}
