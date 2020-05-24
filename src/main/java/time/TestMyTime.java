package time;

import java.util.Scanner;

public class TestMyTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入日期，格式为yyyy-MM-dd");
        String str = sc.next();
        MyTime.time(str);
    }
}
