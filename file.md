##1、文件的创建
    三种方式：
           （1）File(File parent, String child) parent标示父路径，child表示子路径
           （2）File(String pathname) 将指定路径名字符串转换为抽象路径名创建一个新文件。
           （3）File(String parent,String child) 父路径和子路径都为字符串，通过拼接创建一个新文件。
    常用方法：
            boolean mkdir() 在创建目录时，父级目录必须存在，如果不存在则创建失败，返回false。
            boolean mkdirs() 在创建目录时，父级目录不必须存在，如果不存在则一起创建，返回true。
            boolean delete() 删除一个目录时，该目录为空才能删除，若目录下存在文件或目录时不能删除，返回false。
            boolean rename() 当且仅当命名成功时，返回true，否则返回false。
            boolean isDirectory() 判断此抽象路径名表示的文件是否是一个目录。
 
##2、文件的输入和输出
    输入：写入内容到文件。
    输出：读取文件内容。
    
    文件输入和输出流的划分：
                       从流向划分：
                                输入流：InputStream和Reader
                                输出流：OutpurStream和Writer
                       从流的读取方式：
                                字节流：InputStream和OutputStream
                                字符流：Reader和Writer  
                                
    InputStream是一个抽象类，不能直接实例化，对应的子类继承它。
          创建对象：
                 InputStream input = new FileInputStream();
          读取方法：
                 int read() 如果达到流的末尾，返回-1；
    
    OutputStream是一个抽象类，不能直接实例化，对应的子类继承它。
          创建对象：OutPutStream out = new FileOutPutStream();
          常用方法：
                  FileOutputStream(File file) 创建一个指向File对象的文件写入数据。
                  FileOutputStream(File file,boolean append) 创建一个文件对象写入数据，当boolean为ture时，在上次写入后追加。
                  FileOutputStream(String name) 创建一个文件路径的字符串，写入数据。
                  FileOutputStream(String name,boolean append) 在上次写入后追加。
                  close() 关闭输出流并释放此流有关的系统资源。
                  flush() 刷新此流并强制写出所有缓冲的输出字节。
                  write(byte[] b) 将b.length个字节从数组中写入此输出流。
                  write(byte[] b,int off,int len) 将指定的byte[]数组从第几个字节开始输出并输出多少个字节。
                  write(int b) 将指定的字节写入此输出流。
         
    Reader用于读取字符流的抽象类，子类必须实现的方法只有read(char[],int,int)和close()
          创建对象：
                 Reader reader = new FileReader(File file);
    
    Writer写入字符流的抽象类，子类必须实现的方法仅有write(char[],int,int)、flush()和close().
          创建对象：
                 Writer w = new FileWriter(File file);
     
    高效流的读取与写入：
          读取：BufferedReader
              创建对象：
                     BufferedReader br = new BufferedReader(new FileReader(new File(路径)));
              读取方法：
                     String readLine() 读取一行，如果到达流末尾，则返回null；
          
          写入：BufferedWriter
              创建对象：
                     BufferedWriter bw = new BufferedWriter(new FileWriter(new File(路径)));
              常用方法：
                     writer() 把数据写入的文件中.
                     flush() 刷新此流并强制写出所有缓冲的输出字节.
      
    转换流：
         OutputStreamWriter
               是字符流通向字节流的桥梁，可使用指定的charset将要写入流中的字符编码成字节。他使用的字符集可以由名称指定或显示给定，否则将接受
               平台默认的字符集。
                
                方法：
                    OutputStreamWriter(OutpurStream out) 创建使用默认字符编码.    
                    OutputStreamWriter(OutpurStream out,Charset cs) 创建使用给定字符集.                     
          
         InputStreamReader
                字节流是通向字符流的桥梁，可使用指定的charset读取字节并将其解码为字符。他使用的字符集可以由名称指定或显示给定，否则将接受平台
                默认的字符集。 
                
          