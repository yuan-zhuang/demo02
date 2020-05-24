package time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

public class LocalDateTimeDemo {

    public static void main(String[] args){

       //demo01();
       //demo02();
       //demo03();
       //demo04();
       //demo05();
        demo06();
    }

    public static void demo01(){
        //获取当前系统时间
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        //对日期增加
        LocalDateTime dateTime = ldt.plusYears(2);
        System.out.println(dateTime);
        LocalDateTime dateTime01 = dateTime.minusDays(10);
        System.out.println(dateTime01);

        //get方法
        System.out.println(dateTime.getYear());
        System.out.println(dateTime.getMonthValue());
        System.out.println(dateTime.getDayOfMonth());
        System.out.println(dateTime.getDayOfWeek());
        System.out.println(dateTime.getDayOfYear());

    }

    //时间戳
    public static void demo02(){
        //Instant: 时间戳（以1970-01-01 00：00：00到某个时间的毫秒值）
        Instant instant = Instant.now();
        System.out.println(instant);//默认获取UTC时区
        //调整时区差
        OffsetDateTime odt = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(odt);
        //获取毫秒数
        long time = instant.toEpochMilli();
        System.out.println(time);
    }

    //计算两个时间/日期之间的间隔
    public static void demo03(){
        Instant instant = Instant.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant instant01 = Instant.now();
        //Duration计算两个时间之间的间隔
        Duration duration = Duration.between(instant,instant01);
        System.out.println(duration.toMillis());
        System.out.println("-------------------");

        LocalTime localTime01 = LocalTime.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LocalTime localTime02 = LocalTime.now();
        System.out.println(Duration.between(localTime01,localTime02).toMillis());
        System.out.println("------------------ ");

        //Period计算两个日期之间的间隔
        LocalDate localDate01 = LocalDate.now();
        LocalDate localDate02 = LocalDate.of(2019,3,10);
        Period period = Period.between(localDate02,localDate01);
        System.out.println(period);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
    }

    //temporalAdjuster: 时间校正器
    public static void demo04(){
        LocalDateTime ldt01 = LocalDateTime.now();
        System.out.println(ldt01);

        //通过with修改日期和时间
        LocalDateTime ldt02 = ldt01.withDayOfMonth(10);
        System.out.println(ldt02);

        //查看下一个日期是什么时候
        LocalDateTime ldt03 = ldt01.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(ldt03);
    }

    //DateTimeFormatter: 格式化时间或日期
    public static void demo05(){
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime ldt = LocalDateTime.now();
        String date = ldt.format(dtf);
        System.out.println(date);
        System.out.println("--------------");

        //自定义时间和日期格式
        DateTimeFormatter dtf01 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒");
        LocalDateTime ldt01 = LocalDateTime.now();
        String time = ldt01.format(dtf01);
        System.out.println(time);

        //解析时间字符串
        LocalDateTime ldt02 = ldt01.parse(time,dtf01);
        System.out.println(ldt02);
    }

    //带时区的时间：ZonedDate、ZonedTime、ZonedDateTime
    public static void demo06(){
        //获取一组可用时区
        Set<String> set = ZoneId.getAvailableZoneIds();
        System.out.println(set);

        //获取时区的时间
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Aqtau"));
        System.out.println(localDateTime);

        LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Asia/Aqtau"));
        //带时区的时间
        ZonedDateTime zdt = ldt.atZone(ZoneId.of("Asia/Aqtau"));
        System.out.println(zdt);
    }
}
