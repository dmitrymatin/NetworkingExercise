package server;

public class ServerStarter {
    public static void main(String[] args) {
        //testSimpleServer();
        //testMultipleClientServer();
        testMultiThreadedServer();
    }

    private static void testSimpleServer() {
        SimpleServer server = new SimpleServer();
        server.launch();
    }

    private static void testMultipleClientServer() {
        MultiClientServer server = new MultiClientServer();
        server.launch();
    }

    private static void testMultiThreadedServer() {
        MultiThreadedServer server = new MultiThreadedServer(7070);
        server.launch();
    }
}
