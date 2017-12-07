package paperbot;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Logger;

public class InputHandler implements KeyListener {

    private boolean[] keys = new boolean[120];
    private boolean isUpPressed, isDownPressed, isLeftPressed, isRightPressed;
    private boolean isPausePressed, isCancelPressed;

    private static Logger log = Logger.getLogger(InputHandler.class.getName());

    private static InputHandler instance;

    private InputHandler() {

    }

    static {
        try {
            instance = new InputHandler();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized InputHandler getInstance() {
        return instance;
    }

    public void update() {
        isUpPressed = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
        isDownPressed = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
        isLeftPressed = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
        isRightPressed = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];

        isPausePressed = keys[KeyEvent.VK_P];
        isCancelPressed = keys[KeyEvent.VK_C];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
        log.finest(e.getKeyCode() + " pressed!");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
        log.finest(e.getKeyCode() + " released!");
    }

    public boolean isUpPressed() {
        return isUpPressed;
    }

    public boolean isDownPressed() {
        return isDownPressed;
    }

    public boolean isLeftPressed() {
        return isLeftPressed;
    }

    public boolean isRightPressed() {
        return isRightPressed;
    }

    public boolean isPausePressed() {
        return isPausePressed;
    }

    public boolean isCancelPressed() {
        return isCancelPressed;
    }

}
