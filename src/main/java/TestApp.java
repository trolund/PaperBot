import java.awt.*;
import java.awt.event.KeyEvent;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestApp {

    public List<player> playerlist = new ArrayList<player>();
    private final static String PLAYER_INIT = "PLAY {\"username\":\"Trolle\", \"party\":\"eu3942d3\", \"skinny\":\"001\"}";

    public static void main(String[] args) {
        try {

            // open websocket
            final WebsocketClientEndpoint clientEndPoint = new WebsocketClientEndpoint(new URI("wss://eu1.paper-io.com:3843/"));

            // add listener
            clientEndPoint.addMessageHandler(new WebsocketClientEndpoint.MessageHandler() {
                public void handleMessage(String message) {
                    System.out.println(message);
                }
            });


            // send message to websocket
            clientEndPoint.sendMessage(PLAYER_INIT);

            // wait 5 seconds for messages from websocket
           Thread.sleep(1000);

           while(true){

               clientEndPoint.sendMessage("KEYPRESS {\"key\":38}");

               Thread.sleep(1000);

               clientEndPoint.sendMessage("KEYPRESS {\"key\":39}");

               Thread.sleep(1000);

               clientEndPoint.sendMessage("KEYPRESS {\"key\":40}");

               Thread.sleep(1000);

               clientEndPoint.sendMessage("KEYPRESS {\"key\":41}");

               Thread.sleep(1000);
           }



        } catch (InterruptedException ex) {
            System.err.println("InterruptedException exception: " + ex.getMessage());
        } catch (URISyntaxException ex) {
            System.err.println("URISyntaxException exception: " + ex.getMessage());
        }
    }



}