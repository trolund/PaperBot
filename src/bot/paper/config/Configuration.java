package bot.paper.config;

public class Configuration {

    public String title = "PaperBot";
    public String version = "v0.00a";

    public int width = 1280;
    public int height = 720;

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

}