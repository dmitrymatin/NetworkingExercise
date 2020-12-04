package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiClientServer {
    private final int port = 6060;
    private int data = 10;
    private boolean listen = false;

    public void launch() {
        listen = true;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Создан ServerSocket, port: " + port);

            while (listen) {
                Socket socket = serverSocket.accept();
                System.out.println("В цикле ServerSocket ожидает входящие запросы от клиентов на порт " + port);

                socket.getOutputStream().write(data);
                System.out.println("В OutputStream клиентского сокета записано: " + data);

                socket.close();
                System.out.println("Закрыт клиентский сокет на стороне сервера\n");
            }

            serverSocket.close();
            System.out.println("Закрыт серверный сокет (ServerSocket)");

        } catch (IOException e) {
            listen = false;
            e.printStackTrace();
        }
    }
}
