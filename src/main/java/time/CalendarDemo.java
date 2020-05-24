package time;

import java.util.Calendar;
import java.util.Date;

public class CalendarDemo {

    public static void main(String[] args) {
        getTime();
        setTime();
        addTime();
    }

    private static void getTime() {
        Calendar c = Calendar.getInstance();
        System.out.println(c);

        //获取当前年份
        int year = c.get(Calendar.YEAR);
        System.out.println(year);

        //获取当前月份，西方的月份0-11，东方时1-12，所以月份需要加1；
        int month = c.get(Calendar.MONTH)+1;
        System.out.println(month);

        //获取当前几号
        int today = c.get(Calendar.DAY_OF_MONTH);
        System.out.println(today);

        //也是获取当前几号
        today = c.get(Calendar.DATE);
        System.out.println(today);

        //返回一个表示此Calendar的时间值的Date对象。
        Date date = c.getTime();
        System.out.println(date);
    }

    public static void setTime(){
        Calendar c = Calendar.getInstance();
        //设置年份
        c.set(Calendar.YEAR,2021);
        int year = c.get(Calendar.YEAR);
        System.out.println(year);

        c.set(2030,6,15);
        int month = c.get(Calendar.MONTH);
        System.out.println(month);
    }

    public static void addTime(){
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR,2);
        //增加年份
        int year = c.get(Calendar.YEAR);
        System.out.println(year);

        //减少月份
        c.add(Calendar.MONTH,-2);
        int month = c.get(Calendar.MONTH)+1;
        System.out.println(month);
    }

}
