package time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyTime {

    public static void time(String time){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //解析字符串转换为Date
        LocalDate localDate = LocalDate.parse(time,dtf);
        System.out.println(localDate.getYear()+"年");
        System.out.println(localDate.getMonthValue()+"月");
        System.out.println(localDate.getDayOfMonth()+"日");
        System.out.println("第"+localDate.getDayOfYear()+"天");
        System.out.println(localDate.getDayOfWeek());
    }
}
