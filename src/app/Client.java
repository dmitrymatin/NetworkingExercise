package app;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public void launch(int port) {
        try {
            Socket socket = new Socket("localhost", port);
            System.out.println("Создан клиентский сокет, port: " + port);

            InputStream is = socket.getInputStream();
            System.out.println("Получена ссылка на объект входного потока");

            System.out.println(is.read());
            System.out.println("Прочитан байт из объекта входного потока");

            socket.close();
            System.out.println("Клиентский сокет для порта " + port + " закрыт\n");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
