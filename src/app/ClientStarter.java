package app;

public class ClientStarter {
    public static void main(String[] args) {
        //testSimpleServer();
        //testMultipleClientServer();
        testMultiThreadedServer();
    }

    private static void testSimpleServer() {
        Client client = new Client();
        client.launch(5050);
    }

    private static void testMultipleClientServer() {
        Client client = new Client();
        client.launch(6060);
    }

    private static void testMultiThreadedServer() {
        Client client = new Client();

        for (int i = 0; i < 100; i++){
            System.out.println("Клиент " + i + " делает запрос");
            client.launch(7070);
        }
    }
}
