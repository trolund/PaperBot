import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class main {

    static int cont;
    static int time =  0;

    public static void main(String[] args) {

        cont =0;


        Robot r = null;
        try {
            r = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }



        while(true){

            int randomNum = 1500 + (int)(Math.random() * 15000);

            time = 800000 + randomNum;

            try {
                TimeUnit.MICROSECONDS.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            r.keyPress(KeyEvent.VK_DOWN);
            r.keyRelease(KeyEvent.VK_DOWN);


            try {
                TimeUnit.MICROSECONDS.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            r.keyPress(KeyEvent.VK_RIGHT);
            r.keyRelease(KeyEvent.VK_RIGHT);


            try {
                TimeUnit.MICROSECONDS.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            r.keyPress(KeyEvent.VK_UP);
            r.keyRelease(KeyEvent.VK_UP);


            try {
                TimeUnit.MICROSECONDS.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            r.keyPress(KeyEvent.VK_LEFT);
            r.keyRelease(KeyEvent.VK_LEFT);



        }

    }

}
