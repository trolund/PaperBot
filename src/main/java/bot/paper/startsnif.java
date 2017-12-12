package bot.paper;

//import com.sun.corba.se.spi.activation.Server;

import java.net.InetSocketAddress;
import java.net.URI;

import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.*;

import java.net.InetSocketAddress;
import java.net.URI;

public class startsnif {






    public static void main(String[] args) throws Exception {
       Server server = new Server(new InetSocketAddress("127.0.0.1", 2904));
      server.start();
        Sniffer sniffer = new Sniffer(new URI("wss://eu1.paper-io.com:" + "3841/"), new Draft_6455(), server);
        try {
            sniffer.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}