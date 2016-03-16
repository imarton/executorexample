package executorexample;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Starter {

	private static final int taskNum = 10000; //feladatok száma
	private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 
	
	public static void startCachedPool() {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		for (int i = 0; i < taskNum; i++) {
			LoggingTask task = new LoggingTask("Task_"+i);
			System.out.println("New Task created: " + task.getName());
			executor.execute(task);
			
		}		
		executor.shutdown();
	}
	
	
	public static void startFixedPool() {
		int maxThread = 100; 
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(maxThread);
		for (int i = 0; i < taskNum; i++) {
			LoggingTask task = new LoggingTask("Task_"+i);
			System.out.println("New Task created: " + task.getName());
			executor.execute(task);
			
		}		
		executor.shutdown();
	}
	
	public static void startSchedulePool() {
		int maxThread = 2;
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(maxThread);

		LoggingTask task = new LoggingTask("Task_"+1);
		System.out.println("-- Start: " + sdf.format(new Date()));
		System.out.println(sdf.format(new Date()) +" New Task created: " + task.getName());
		executor.scheduleAtFixedRate(task, 10, 5, TimeUnit.SECONDS);
		
		System.out.println("Main go to sleep: " + sdf.format(new Date()));
		try {
			TimeUnit.SECONDS.sleep(180);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Main sleep end: " + sdf.format(new Date()));
		executor.shutdown();		
	}
	
	public static void main(String[] args) {
		
		// példa a cached Thread Pool-ra
//		startCachedPool();

		// példa a fixed Thread Pool-ra
//		startFixedPool();
		
		// példa a fixed Thread Pool-ra
		startSchedulePool();
		
		System.out.println("--- Here is the end. (app) ---");
	}

}
