package multi_thread;

public class Execution {

	public static void main(String args[]) {
		Thread R1 = new MultiThread("Thread-1 as User1");

		Thread R2 = new MultiThread("Thread-2 as User2");

		Thread R3 = new MultiThread("Thread-3 as User3");
		R1.start();
		R2.start();
		R3.start();

		try {
			R1.join();
			R2.join();
			R3.join();
		} catch (InterruptedException e) {
			System.out.println("Thread has been cut off");
		}
		System.out.println("Threads are complete!");
	}
}
