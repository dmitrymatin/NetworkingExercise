package server;

import java.io.IOException;
import java.net.Socket;
import java.util.Random;

public class ThreadedLogic implements Runnable {
    private Socket socket;
    private int data = 50;

    public ThreadedLogic(Socket socket) {
        this.socket = socket;
        this.data = data;
    }

    public void run() {
        try {
            heavyComputation();

            int data = new Random().nextInt();
            socket.getOutputStream().write(data);
            System.out.println("В OutputStream клиентского сокета записано: " + data);

            //socket.close();
//            System.out.println("Закрыт клиентский сокет на стороне сервера\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Socket getSocket() {
        return socket;
    }

    private void heavyComputation() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Поток " + Thread.currentThread().getName() + " закончил выполнение сложных вычислений");
    }
}
