import java.util.Timer;
import java.util.TimerTask;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class interval {

    public static Timer timer = new Timer();

    public static void main(String[] args) throws Exception {

        timer.scheduleAtFixedRate(new TimerTask(){
            
            public void run(){

                LocalTime time = LocalTime.now();
                DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");

                System.out.println(time.format(format));

            }

        },0,1000);

    }
}