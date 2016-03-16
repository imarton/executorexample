package executorexample;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class LoggingTask implements Runnable {
    private String name;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 
    
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
            System.out.println(sdf.format(new Date()) +" "+ name + " is working...");
            TimeUnit.SECONDS.sleep(sleepingTime);
            System.out.println(sdf.format(new Date()) + " "+ name + "  done!");
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
    }

}
