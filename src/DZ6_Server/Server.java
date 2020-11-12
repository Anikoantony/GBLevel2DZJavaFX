package DZ6_Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    // Сервер для обеспечения рукопожатия клиент - сервер
    static ServerSocket server;

    // сокет для соединения клиент-сервер
    private static Socket socket;
    private static final int PORT=8189;
    private static Scanner in;

    private static  PrintWriter out;
    private static  DataOutputStream out2;
    private static DataInputStream in2;

    public static void main(String[] args) {
        try {
            server=new ServerSocket(PORT);
            System.out.println("Server started!");

            socket = server.accept();
            System.out.println("client connected");

            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(),true);

            in2 = new DataInputStream(socket.getInputStream());
            out2 = new DataOutputStream(socket.getOutputStream());


            while (true)
            {String str = in.nextLine();
            if(str.equals("/end")){break;}
                System.out.println("Client: "+str);
            out.println("echo: " + str);
            out2.writeUTF("echo: " + str);
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("Client disconected!");

            try {
                //System.out.println("Client disconected!");

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();

            } catch (IOException e) {
                e.printStackTrace();

            }
        }


    }

}
