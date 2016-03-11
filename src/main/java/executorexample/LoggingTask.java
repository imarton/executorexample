package executorexample;

import java.util.concurrent.TimeUnit;

public class LoggingTask implements Runnable {
    private String name;
    
    public LoggingTask(String name) 
    {
        this.name = name;
    }
     
    public String getName() {
        return name;
    }
 
    public void run() 
    {
        try
        {
            Long sleepingTime = (long) (Math.random() * 10);
            System.out.println(name + " is working...");
            TimeUnit.SECONDS.sleep(sleepingTime);
            System.out.println(name + "  done!");
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
    }

}
