package bot.paper.gui;

import bot.paper.config.Configuration;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private final Configuration config = Configuration.getInstance();

    public MainFrame() {
        super();
        setTitle(config.title);

        Dimension size = new Dimension(config.width, config.height);
        setSize(size);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);

        initFrame();
    }

    /*
    * Initialize settings for the JFrame.
    */
    private void initFrame() {
        setTitle(config.title + " " + config.version);
        setResizable(false);
        setLocationRelativeTo(null);
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        requestFocus();
    }

}