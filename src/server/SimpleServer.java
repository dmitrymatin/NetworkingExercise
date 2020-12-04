package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    private final int port = 5050;
    private int data = 10;

    public void launch() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Создан ServerSocket, port: " + port);

            System.out.println("ServerSocket ожидает входящие запросы от клиентов на порт " + port);
            Socket socket = serverSocket.accept();
            System.out.println("Получен запрос от клиента");

            socket.getOutputStream().write(data);
            System.out.println("В OutputStream клиентского сокета записано: " + data);

            socket.close();
            System.out.println("Закрыт клиентский сокет на стороне сервера");
            serverSocket.close();
            System.out.println("Закрыт серверный сокет (ServerSocket)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
