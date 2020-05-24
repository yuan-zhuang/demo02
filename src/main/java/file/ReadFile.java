package file;

import java.io.*;

public class ReadFile {
    public static void main(String[] args) {
       read();
       bufferedReader();
    }

    public static void read(){
        Reader reader = null;
        try {
            reader = new FileReader("src/main/java/test.txt");
            char[] c = new char[1024];
            while(reader.read(c)!=-1){
                System.out.println(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void bufferedReader(){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("src/main/java/t.txt"));
            String str = "";
            while ((str=br.readLine())!=null){
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
