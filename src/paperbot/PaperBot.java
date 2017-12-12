package paperbot;

import config.Configuration;

import java.awt.*;
import java.awt.event.KeyEvent;

public class PaperBot implements Runnable {

    private static int time = 0;

    private Robot robot;

    private final InputHandler input = InputHandler.getInstance();
    private final Configuration config = Configuration.getInstance();

    private static PaperBot instance;

    private Thread botThread;
    private State state = State.IDLE;

    private enum State {
        IDLE, RUNNING, PAUSED;
    }

    private PaperBot() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
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

    @Override
    public void run() {
        while (state == State.RUNNING) {
            update();
        }
    }

    private void update() {
        input.update();
        updateBot();
    }

    private void updateBot() {
        int randomNum = 1500 + (int) (Math.random() * 15000);

        time = 800000 + randomNum;

        config.sleep(time);

        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);

        config.sleep(time);

        robot.keyPress(KeyEvent.VK_RIGHT);
        robot.keyRelease(KeyEvent.VK_RIGHT);

        config.sleep(time);

        robot.keyPress(KeyEvent.VK_UP);
        robot.keyRelease(KeyEvent.VK_UP);

        config.sleep(time);

        robot.keyPress(KeyEvent.VK_LEFT);
        robot.keyRelease(KeyEvent.VK_LEFT);
    }

    public synchronized void start() {
        if (state != State.RUNNING) {
            state = State.RUNNING;
            botThread = new Thread(this, config.title);
            botThread.start();
        }
    }

    public synchronized void stop() {
        if (state == State.RUNNING)
            state = State.IDLE;
    }

    public synchronized void pause() {
        if (state == State.RUNNING)
            state = State.PAUSED;
    }

}