import java.io.*;
import java.net.Socket;

public class Main {
    public static void main(String [] args) throws IOException, InterruptedException {
//        while(true) {
//            String line;
//            Process p = Runtime.getRuntime().exec("telnet localhost 5000");
//            Reader r = new InputStreamReader(p.getInputStream());
//            BufferedReader in = new BufferedReader(r);
//            while ((line = in.readLine()) != null) {
//                System.out.println(line);
//                if(line != "Connected") Runtime.getRuntime().exec("java -jar RaspiOpener.jar");
//            }
//            in.close();
//            Thread.sleep(30000);
//        }
        while(true) {
            pingz(5000);
            Thread.sleep(20000);
        }
    }

    public static void ping(int port) throws IOException {
        Socket socket = new Socket("localhost", port);

        InputStream input = socket.getInputStream();
        InputStreamReader reader = new InputStreamReader(input);

        int character;
        StringBuilder data = new StringBuilder();

        while ((character = reader.read()) != -1) data.append((char) character);
        System.out.println(data);
    }

    public static void pingz(int port) throws IOException {
        String FromServer;
        String ToServer;
        try {
            Socket clientSocket = new Socket("localhost", 5000);

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(
                System.in));

        PrintWriter outToServer = new PrintWriter(
                clientSocket.getOutputStream(), true);

        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(
                clientSocket.getInputStream()));



            ToServer = "How are you?";
            outToServer.println(ToServer);

            FromServer = inFromServer.readLine();
            System.out.println(FromServer);

            FromServer = inFromServer.readLine();
            System.out.println(FromServer);
        }
        catch(Exception e){
            Runtime.getRuntime().exec("java -jar RaspiOpener.jar");
            System.out.println("geckräscht");
        }
    }

}
