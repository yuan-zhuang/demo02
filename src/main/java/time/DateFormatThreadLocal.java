package time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatThreadLocal {

    public static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>(){
      protected DateFormat initialValue(){
          return new SimpleDateFormat("yyyyMMdd");
      }
    };

    public static Date convert(String time) throws ParseException {
        return df.get().parse(time);
    }
}
