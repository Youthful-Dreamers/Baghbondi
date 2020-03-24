package NewBaghbondi;

import org.junit.jupiter.api.Test;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class TurnTimer{
                Turn turn;
                Timer goatTimer = new Timer();
                Timer tigerTimer = new Timer();
                TimerTask task = new TimeCounter();
                void runGoatTimer(){
                    System.out.println("..........aaaaaaaa");
                    goatTimer.schedule(task,100,1000);
                }


        }
class TimeCounter extends TimerTask{

        @Override
        public void run() {
            System.out.println("..........");
        }
}
class TestTimer{
    @Test
    void testTimer(){
        TurnTimer timer = new TurnTimer();
        timer.runGoatTimer();
        System.out.println("ok ok");
       // Scanner sc = new Scanner(System.in);
        //sc.nextInt();
    }
}