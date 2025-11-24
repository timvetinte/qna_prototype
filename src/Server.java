import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public void start(Object sender) {
        try (ServerSocket ss = new ServerSocket(4444);
             Socket client = ss.accept();
             ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
             ObjectInputStream  ois = new ObjectInputStream(client.getInputStream())) {
            Question currentQuestion = new Question();
            Answer sentAnswer = new Answer();

            System.out.println("SERVER RUNNING...");

            oos.writeObject(sender);
            oos.flush();

            DAO dao = new DAO();

            while (true) {
                Object incoming = ois.readObject();
                if (incoming == null) break;

                if (incoming instanceof Answer) {
                    System.out.println(sentAnswer.getAnswerText());
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void main() {

    }
}
