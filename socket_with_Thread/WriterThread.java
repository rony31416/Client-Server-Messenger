package socket_with_Thread;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class WriterThread implements Runnable {

    ObjectOutputStream objOut;
    String name;
    Thread thread;

    WriterThread(ObjectOutputStream objOut, String name) {
        this.objOut = objOut;
        this.name = name;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            String message = sc.nextLine();
            if (message.equals("exit")) {
                System.out.println("okey");
                 break;
            }
            // sent to server...
            try {
                objOut.writeObject(message);
                System.out.println("messsage sent...");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}
