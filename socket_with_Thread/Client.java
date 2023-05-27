package socket_with_Thread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("Client started..");
        
        Socket socket = new Socket("127.0.0.1", 22222);
        System.out.println("Client Connected..");

        ObjectOutputStream objOut = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream objInput = new ObjectInputStream(socket.getInputStream());

        new WriterThread(objOut, "Client1");
        new ReaderThread(objInput, "Client1");


    }
}
