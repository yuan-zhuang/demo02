package time;

import java.util.Date;

public class DateTime {
    public static void main(String[] args) {
        time01();

    }

    public static void time01(){
        Date date = new Date();
        System.out.println(date);

        //Date(long date)：传递毫秒值，直接把毫秒转换成Date日期
        Date date1 = new Date(1000);
        System.out.println(date1);

        //获取现在到19701月1日0时0分的毫秒数
        long time = date.getTime();
        System.out.println(time);


        //若调用Date对象所包含的日期比date指定的对象所包含的日期晚，返回true，否者返回false。
        //若调用Date对象所包含的日期比date指定的对象所包含的日期早，返回true，否者返回false。
        boolean bool = date.after(date1);
        System.out.println(bool);
        bool = date.before(date1);
        System.out.println(bool);

        //比较调用对象所包含的日期和指定的对象包含的日期
        int a = date.compareTo(date1);
        System.out.println(a);

        //把调用的Date对象转换成字符串并返回结果。
        String str = date.toString();
        System.out.println(str);
    }
}
