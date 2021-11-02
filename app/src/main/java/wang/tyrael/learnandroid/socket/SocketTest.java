package wang.tyrael.learnandroid.socket;

import java.io.IOException;
import java.net.ServerSocket;

public class SocketTest {
    public void test() {
        int port = 9898;
        try {
            ServerSocket server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
