package socket;


import java.io.*;
import java.net.Socket;

public class Client {
    public static final int port = 10086;
    public static final String host = "127.0.0.1";

    public static void main(String[] args) {
            Socket s = null;
            try {
                s = new Socket(host,port);
               String str = "hello world!";
               OutputStream os = s.getOutputStream();
               os.write(str.getBytes());
                System.out.println("写入成功!");
                os.close();
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
