package executorexample;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Starter {

	public static void main(String[] args) {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			LoggingTask task = new LoggingTask("Task_"+i);
			System.out.println("New Task created: " + task.getName());
			executor.execute(task);
			
		}		
		executor.shutdown();

	}

}
