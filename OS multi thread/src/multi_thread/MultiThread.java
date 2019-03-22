package multi_thread;


import java.util.ArrayList;
import java.util.HashMap;

class MultiThread extends Thread {
	private Thread t;
	private String threadName;
	ArrayList<String> list1 = new ArrayList<>();
	ArrayList<String> list2 = new ArrayList<>();
	ArrayList<String> list3 = new ArrayList<>();
	HashMap<String, ArrayList> total = new HashMap<>();

	MultiThread(String name) {
		threadName = name;
		System.out.println("Creating " + threadName);
	}

	public void run() {

		System.out.println("Running " + threadName);

		try {
			for (int i = 0; i < 5; i++) {
				System.out.println("Thread: " + threadName + " borrowed " + (total.get(threadName)).get(i)
						+ " with Thread priority " + t.getPriority());

				// Set the timer for the scheduling of the thread.
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {
			System.out.println("Thread " + threadName + " interrupted.");
		}
		System.out.println("Thread " + threadName + " exiting.");
	}

	public void start() {
		System.out.println("Starting " + threadName);
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
		// Setting priority and adding books to list while putting them all in a HashMap
		switch (threadName) {
		case "Thread-1 as User1":
			t.setPriority(10);
			total.put(threadName, bookshelf1());
			break;
		case "Thread-2 as User2":
			t.setPriority(8);
			total.put(threadName, bookshelf2());
			break;
		case "Thread-3 as User3":
			t.setPriority(6);
			total.put(threadName, bookshelf3());
			break;

		}
	}

	public ArrayList<String> bookshelf1() {
		list1.add("AMA Guides to the Evaluation of Work Ability and Return to Work");
		list1.add("Heard In Data Science Interviews");
		list1.add("Make It Stick: The Science of Successful Learning");
		list1.add("Sapiens: A Brief History of Humankind");
		list1.add("Health Systems Science");
		return list1;

	}

	public ArrayList<String> bookshelf2() {
		list2.add("Where the Crawdads Sing");
		list2.add("Little Fires Everywhere");
		list2.add("Beneath a Scarlet Sky");
		list2.add("Milk and Honey");
		list2.add("Tom Clancy Oath of Office");
		return list2;

	}

	public ArrayList<String> bookshelf3() {
		list3.add("Mind Platter");
		list3.add("What Dreams May Come");
		list3.add("More Than Words");
		list3.add("Criminal Psychology");
		list3.add("How Children Succeed: Grit, Curiosity, and the Hidden Power of Character");
		return list3;

	}
}

