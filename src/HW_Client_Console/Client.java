package HW_Client_Console;

import javafx.fxml.Initializable;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Client implements Initializable {

    private static Socket socket;
    private static final String IP_ADRESS = "localhost";
    private static final int PORT = 8189;
    private static Scanner in;
    private static Scanner in2;
    private static  PrintWriter out;

    public static void main(String[] args) {
        try {
            socket =new Socket(IP_ADRESS,PORT);
            System.out.println("Связь на клиенте установлена");
            in = new Scanner(System.in);
            out = new PrintWriter(socket.getOutputStream(),true);
            in2 = new Scanner(socket.getInputStream());

            // поток для чтения сообщений от Сервера:

            new Thread(new Runnable() {
                @Override
                public void run() {

                    while (true)
                    { String str2 = in2.nextLine();
                        System.out.println("Server: " + str2);
                    //if (str2.equals("/end"))
                      //  break;
                    }
                }
            }).start();

            // передача серверу сообщений:

            while (true)
            {String str = in.nextLine();
                if(str.equals("/end")){break;}
                System.out.println("Client: " + str);
                out.println(str);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            socket =new Socket(IP_ADRESS,PORT);
            System.out.println("Связь на клиенте установлена");
            in = new Scanner(System.in);
            out = new PrintWriter(socket.getOutputStream(),true);

            while (true)
            {String str = in.nextLine();
                if(str.equals("/end")){break;}
                System.out.println("Client: "+str);
                out.println("Client: " + str);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
