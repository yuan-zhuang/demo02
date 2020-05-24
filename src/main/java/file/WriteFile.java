package file;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteFile {

    public static void main(String[] args) {
        writer();
        bufferedWriter();
    }

    public static void writer(){
        Writer w = null;
        char[] c = null;
        try {
            w = new FileWriter("src/main/java/test.txt");
            for(int i=0;i<100000;i++) {
                w.write("江融信七组\n");
                w.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(w!=null){
                try {
                    w.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void bufferedWriter(){
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("src/main/java/t.txt"));
            for(int i = 0;i<100000;i++){
                bw.write("江融信七组\n");
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bw!=null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
