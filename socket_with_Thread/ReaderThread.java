package socket_with_Thread;

import java.io.IOException;
import java.io.ObjectInputStream;

public class ReaderThread implements Runnable {
    ObjectInputStream objInput;
    String name;
    Thread thread;

    ReaderThread(ObjectInputStream objInput, String name) {
        this.objInput = objInput;
        this.name = name;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            // receive from server..
            Object reseivedObject = objInput.readObject();
            System.out.println(name +" got message : " + (String) reseivedObject);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
