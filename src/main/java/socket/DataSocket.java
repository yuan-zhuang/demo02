package socket;

import sun.jvm.hotspot.debugger.ThreadAccess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class DataSocket {
    public static int port = 10086;
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                DatagramSocket ds = null;
                try {
                    ds = new DatagramSocket(port);
                    while (true) {
                        byte[] b = new byte[1024];
                        DatagramPacket dp = new DatagramPacket(b, b.length);
                        ds.receive(dp);
                        byte[] bt = dp.getData();
                        int len = dp.getLength();
                        String str = new String(bt, 0, len);
                        System.out.println(str);
                    }
                } catch (SocketException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(ds!=null){
                        ds.close();
                    }
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                DatagramSocket ds = null;
                BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
                String line = "";
                try {
                    while((line = br.readLine())!=null) {
                        ds = new DatagramSocket();
                        String str = line;
                        byte[] b = str.getBytes();
                        InetAddress addr = InetAddress.getByName("127.0.0.1");
                        System.out.println(addr);
                        DatagramPacket dp = new DatagramPacket(b, b.length, addr,port);
                        ds.send(dp);
                    }

                } catch (SocketException e) {
                    e.printStackTrace();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(ds!=null) {
                        ds.close();
                    }
                }
            }
        });
        t2.start();
    }
}
