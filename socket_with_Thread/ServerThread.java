package socket_with_Thread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerThread implements Runnable {
    Socket clientSocket;
    Thread thread;

    ServerThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
        thread = new Thread(this);
        thread.start();

    }

    @Override
    public void run() {

        try {
            ObjectInputStream objInput = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream objOut = new ObjectOutputStream(clientSocket.getOutputStream());

            // read from client...
            while (true) {
                Object cMsg = objInput.readObject();

                if (cMsg == null) {
                    break;
                }
                System.out.println("From Client: " + (String) cMsg);
                String serverMsg = (String) cMsg;
                serverMsg = serverMsg.toUpperCase();
                // send to client..
                objOut.writeObject(serverMsg);

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
