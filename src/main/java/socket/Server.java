package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        //创建socket对象
        ServerSocket ss = new ServerSocket(10086);
        Socket s = ss.accept();
        String ip = s.getInetAddress().getHostAddress();
        InputStream is = s.getInputStream();
        byte[] bs = new byte[1024];
        is.read(bs);
        System.out.println(ip+"----->"+new String(bs,0,bs.length));
        s.close();
    }


}
