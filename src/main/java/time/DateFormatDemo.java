package time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateFormatDemo {

    public static void main(String[] args) throws ParseException {
        format();
        demo();
    }

    public static void format() throws ParseException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //将日期转换成字符串
        String time = sdf.format(date);
        System.out.println(time);

        //将字符串转换成日期
        String time02 = "2020-01-01 18:30:00";
        //调用parse方法需要处理异常，如果字符串格式不对抛出异常
        Date date02 = sdf.parse(time02);
        System.out.println(date02);
    }

    public static void demo() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入出生日期，格式为yyyy-MM-dd");
        String str = sc.next();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = sdf.parse(str);
        long birthdayTime = birthday.getTime();
        long today = new Date().getTime();
        long time = today - birthdayTime;
        System.out.println(time/1000/60/60/24);
    }
}
