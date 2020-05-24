package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo {
    public static int port = 10086;

    public static void main(String[] args) {

                //1、创建服务端
                ServerSocket ss = null;
                try {
                    ss = new ServerSocket(port);
                    //2、接收客户端连接
                    Socket socket = ss.accept();
                    System.out.println("客户端以连接");
                    //3、发送数据
                    BufferedInputStream bis = new BufferedInputStream(new FileInputStream("/Users/tiantiankaixin/学习资料/a"));
                    OutputStream os = socket.getOutputStream();
                    byte[] b = new byte[2048];
                    int len = 0;
                    while ((len = bis.read(b))!=-1){
                        os.write(b,0,len);
                    }
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
}
