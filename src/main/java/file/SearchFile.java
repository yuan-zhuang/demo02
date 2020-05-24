package file;

import java.io.File;

public class SearchFile {

    public static void main(String[] args) {
        File file = new File("/Users/tiantiankaixin/Downloads");
        found(file);
    }

    public static void found(File file) {
        File[] fs = file.listFiles();
        if (fs!=null) {
            for (File f : fs) {
                if (f.isDirectory()) {
                    found(f); //递归调用
                }
                if (f.isFile()) {
                    System.out.println(f);
                }
            }
        }else{
            System.out.println("没有文件!");
        }
    }

}
