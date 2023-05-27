package socket_without_Thread;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("Client started..");
        Scanner sc = new Scanner(System.in);
        Boolean ok = true;

        while (true) {
            Socket socket = new Socket("127.0.0.1", 22222);
            if (ok) {
                System.out.println("Client Connected..");
                ok = false;
            }

            ObjectOutputStream objOut = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objInput = new ObjectInputStream(socket.getInputStream());

            String message = sc.nextLine();
            // sent to server...
            objOut.writeObject(message);

            try {
                // receive from server..
                Object fromServer = objInput.readObject();
                System.out.println("From Server: " + (String) fromServer);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
