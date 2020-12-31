package lesson4;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable, Closeable {

    private EchoServer server;
    private Socket socket;
    private static int cnt = 0;
    private String userName;
    private ObjectInputStream is;
    private ObjectOutputStream os;
    private boolean running;
    private byte [] buffer;

    public ClientHandler(Socket socket, EchoServer chatServer) throws IOException, ClassNotFoundException {
        this.server = chatServer;
        this.socket = socket;
        this.os = new ObjectOutputStream(socket.getOutputStream());
        this.is = new ObjectInputStream(socket.getInputStream());
        userName = "user#" + cnt;
        running = true;
        buffer = new byte[256];
    }

    @Override
    public void close() throws IOException {
        os.close();
        is.close();
    }

    @Override
    public void run() {
        while (running) {
            try {
                Message message = (Message) is.readObject();
                System.out.println(message);
                server.broadCast(message);
                BufferedWriter bw = new BufferedWriter(new FileWriter("history.txt",true));
                bw.write(message.getSendAt() + ": " + message.getAuthor() + ": " + message.getMessage()+"\n");
                bw.close();
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Exception while read");
                break;
            }
        }
    }

    public boolean isRunning() {

        return running;
    }

    public void setRunning(boolean running) {

        this.running = running;
    }

    public void sendMessage(Message message) throws IOException {
        os.writeObject(message);
        os.flush();
    }
}