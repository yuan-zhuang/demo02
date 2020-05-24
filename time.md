    Java8以前的日期和时间类位于java.util包中。利用日期类提供的方法，可以获取当前的日期和时间，创建日期和时间参数，计算和比
    较时间。
##1、Date类
    Date类是Java中的日期时间类，器构造方法比较多，最常用的就下面两个：
    Date()：使用当前的日期和时间初始化一个对象。
    Date(long millisec):从1970年01月01日00时（格林威治时间）开始以毫秒计算时间。
####常用方法
    after(Date date) 若调用Date对象所包含的日期比date指定的对象所包含的日期晚，返回true，否者返回false。
    befor(Date date) 若调用Date对象所包含的日期比date指定的对象所包含的日期早，返回true，否者返回false。
    compareTo(Date date) 比较调用对象所包含的日期和指定的对象包含的日期，若相等返回0；若前者比后者早，返回负值，否者返回正值。
    getTime() 以毫秒数返回从1970年01月01日00时到目前的时间。
    setTime(long time) 根据time的值，设置时间和日期。time值从1970年01月01日00时开始计算。
    toString() 把调用的Date对象转换成字符串并返回结果。
    
##2、DateFormat类
    java.text.DateFormat是日期/时间格式化子类的抽象类，通过这个类可以帮助我们完成日期和文本之间的转换，也就是可以在Date
    对象与String对象之间进行转换。
    
    格式化：按照指定的格式，从Date对象转换为String对象。
    解析：按照指定的格式，从String对象转换为Date对象。
    
    构造方法：
           由于DateFormat为抽象类，不能直接使用，需要使用其子类java.text.SimpleDateFormat.这个类需要指定一个格式来
           指定格式化或解析的标准，构造方法为：
                public SimpleDateFormat(String pattern) 参数pattern是一个字符串，代表日期时间的自定义格式。
    
    常用成员方法：
              String format(Date date) 按照指定格式，把Date日期格式化为符合格式的字符串。
              Date parse(String source) 把符合格式的字符串解析为Date日期。
    
    常用格式规则：
              标示字符（区分大小写）               含义
                     y                          年
                     M                          月
                     d                          日
                     H                          时
                     m                          分
                     s                          秒
              例如：
                  "yyyy-MM-dd HH:mm:ss" 或 "yyyy年MM月dd日 HH时:mm分:ss秒"
  
##3、Calendar类
    java.util.Calendar是日历类，在Date后出现，替换掉了许多Date的方法，该类将所有可能用到的时间信息封装为静态成员变量，方
    便获取。抽象类Calendar提供类一组方法，允许把以毫秒为单位的时间转换成一些有用的时间组成部分。Calendar不能直接创建对象，
    可以使用静态方法getInstance()获得。
    
    常用方法：
           int get(int field): 返回给定日历字段的值。
           void set(int field,int value): 将给定的日历字段设置为给定值。
           abstract void add(int field,int amount): 根据日历的规则，为给定的日历字段添加或减去指定的时间量。
           Date getTime(): 返回一个表示此Calendar的时间值的Date对象。
           
           Calendar类中的成员变量：
                               字段值                    含义
                               YEAR                     年
                               MONTH                    月
                               DAY_OF_MONTH             月中的天（几号）
                               HOUR                     时（12小时制）
                               HOUR_OF_DAY              时（24小时制）
                               MINUTE                   分
                               SECOND                   秒


##Java8日期
    Java8有一套全新的日期API位于java.time包下，相较以前的API有规律了很多，最大的不同就是原来的是线程不安全的，java8全新的
    API是线程安全的。
####LocalDate、LocalTime、LocalDateTime
    这三个类的实例是不可变的对象，分别表示使用ISO-8601（国际标准组织制定的现代公民的日期和时间表示法）日历系统的日期、时间、
    日期和时间。但并不包含当前的时间信息，也不包含与时区相关的信息。
    
##时区的处理
    Java8中加入了对时区的支持，带时区的时间分别为：
                                           ZonedDate、ZonedTime、ZonedDateTime
    其中每个时区都对应着ID，地区ID都为"{区域}/{城市}"的格式，例如：Asia/shanghai等。
    ZonedId：该类中包含了所有的时区信息
             getAvailableZoneds(): 可以获取所有时区信息
             of(id)：用指定的时区信息获取Zoned对象。
    