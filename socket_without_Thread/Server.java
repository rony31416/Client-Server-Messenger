package socket_without_Thread;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

            ObjectInputStream objInput = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream objOut = new ObjectOutputStream(socket.getOutputStream());

            try {
                // read from client...
                Object cMsg = objInput.readObject();
                System.out.println("From Client: " + (String) cMsg);

                String serverMsg = (String) cMsg;
                serverMsg = serverMsg.toUpperCase();

                // send to client..
                objOut.writeObject(serverMsg);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}