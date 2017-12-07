package config;

import java.util.concurrent.TimeUnit;

public class Configuration {

    public String title = "PaperBot";
    public String version = "v0.00a";

    public int width = 1280;
    public int height = 720;

    public boolean isDebugEnabled = true;

    private static Configuration instance;

    private Configuration() {

    }

    static {
        try {
            instance = new Configuration();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public static synchronized Configuration getInstance() {
        return instance;
    }

    public void sleep(int time) {
        try {
            TimeUnit.MICROSECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}