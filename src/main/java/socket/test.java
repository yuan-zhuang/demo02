package socket;


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLOutput;
import java.util.jar.JarOutputStream;

public class test {

    public static String sourceURL = "http://img.netbian.com/file/2020/0518/8f7e5dd953443cfc101ef3fc9fae395d.jpg";
    public static String localFile = "/Users/tiantiankaixin/学习资料/";
    public static void main(String[] args) {
        String name = sourceURL.split("/")[2];
        System.out.println("name------>"+name);
        String uri = sourceURL.substring(sourceURL.lastIndexOf(name)+name.length());
        System.out.println("uri------->"+uri);
        if(uri.length() == 0){
            uri = "/";
        }
        try {
            InetAddress addr = InetAddress.getByName(name);
            String ip = addr.getHostAddress();
            System.out.println("ip---->"+ip);

            //建立socket连接，输入输出流获取，封装socket输入输出流
            Socket socket = new Socket(ip,80);
            InputStream is = socket.getInputStream();
            OutputStream os  = socket.getOutputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is,"utf-8"));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os,"utf-8"));

            //通过socket发送http请求头，请求服务器回复
            bw.write("GET"+uri+"HTTP/1.1\r\n");
            bw.write("Host"+name+"\r\n");
            bw.write("Connection: close\r\n");
            bw.flush();

            //接收http头，用以判断包头大小，分割包头
            String line = "";
            String contentType = null;
            int contentLen = -1;
            int bias = 0;
            while ((line = br.readLine())!=null){
                System.out.println("line------>"+line);
                //判断包头是否发送结束
                if(line.length() == 0){
                    break;
                }

                //记录包大小
                bias += line.length()+2;
                System.out.println("bias----->"+bias);
                int ct_idx = line.lastIndexOf("Content-Type: ",0);
                System.out.println("ct----->"+ct_idx);
                if(ct_idx != -1){
                    contentType = line.substring(ct_idx+14);
                    System.out.println("contentType----->"+contentType);
                }
                int cl_idx = line.lastIndexOf("Content-Length: ",0);
                if(cl_idx != -1){
                    contentLen = Integer.valueOf(line.substring(ct_idx+16).substring(1)).intValue();
                }
            }
            is.close();
            os.close();
            socket.close();

            socket = new Socket(ip,80);
            is = socket.getInputStream();
            os = socket.getOutputStream();
            bw = new BufferedWriter(new OutputStreamWriter(os,"utf-8"));

            bw.write("GET"+uri+"HTTP/1.1\r\n");
            bw.write("Host"+name+"\r\n");
            bw.write("Connection: close\r\n");
            bw.flush();
            //文件的写入
            is.skip(bias+2);
            String extension = '.'+contentType.split("/")[1].split(";")[0];
            String fileName = "123";
            FileOutputStream fos = new FileOutputStream(localFile+fileName+extension);
            byte[] b = new byte[1024];
            int len;
            while ((len = is.read(b))!= -1){
                fos.write(b,0,len);
            }
            fos.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
