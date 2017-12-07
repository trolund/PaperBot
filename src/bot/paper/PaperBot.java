package bot.paper;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class PaperBot {

    private static int count;
    private static int time = 0;

    private static PaperBot instance;

    private PaperBot() {

    }

    static {
        try {
            instance = new PaperBot();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public static synchronized PaperBot getInstance() {
        return instance;
    }

    public void start() {

        count = 0;

        Robot r = null;
        try {
            r = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }


        while (true) {

            int randomNum = 1500 + (int) (Math.random() * 15000);

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
