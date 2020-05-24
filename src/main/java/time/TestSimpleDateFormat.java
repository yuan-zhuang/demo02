package time;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class TestSimpleDateFormat {

    public static void main(String[] args) throws Exception{
       //final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        Callable<Date> call = new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                //return sdf.parse("20200101");
                return DateFormatThreadLocal.convert("20200101");
            }
        };
        //创建一个长度为10的线程池。
        ExecutorService pool = Executors.newFixedThreadPool(10);

        List<Future<Date>> list = new ArrayList<>();

        for (int i = 0; i <10; i++) {
            list.add(pool.submit(call));
        }

        for(Future<Date> future: list){
            System.out.println(future.get());
        }
        pool.shutdown();
    }
}
