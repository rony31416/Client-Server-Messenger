package socket_with_Thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(22222);
        System.out.println("Server Started..");
        Boolean ok = true;

        while (true) {
            Socket socket = serverSocket.accept();
            if (ok) {
                System.out.println("Client connected..");

                ok = false;
            }
            new ServerThread(socket);

        }

    }

}