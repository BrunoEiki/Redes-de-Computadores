import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GreetClient {
    public static void main(String[] args) {

        PrintWriter out;
        BufferedReader in;

        try (Socket clientSocket = new Socket("127.0.0.1", 6666)) {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            out.println("hello server");
            String resp = in.readLine();

            if ("hello client".equals(resp)) {
                System.out.println("UHUUUUU");
            }

            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}