import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class CustomBackup {
    static long minimum,maximum;
    static long milliSecond,milliSecond1;
    static String filename;
    public void CustomBackup(String srcpath,String dstpath) throws IOException{
        FileCopy fileCopy=new FileCopy();
        fileCopy.copy(srcpath,dstpath);
    }

public  void CustomBackup(String srcpath,String dstpath,long minimum,long maximum) throws IOException{
    File src = new File(srcpath);//源头
    File dest = new File(dstpath);//目的地
    //判断是否为目录，不存在则不作操作
    if(!src.isDirectory()) {
        return;
    }
    //判断目的目录是否存在，不存在就创建目录
    if(!dest.exists()){
    boolean mkdir = dest.mkdir();
    if(!mkdir)return;//如果创建失败，返回
    }
    this.minimum=minimum;
    this.maximum=maximum;
    //获取源头目录下的文件列表组成数组，每个对象代表一个目录或者文件
    File[] srcList = src.listFiles();
    if (null != srcList && srcList.length > 0){
        //遍历源头目录下的文件列表
        for (File aSrcList : srcList) {
            //如果是目录的话
            if (aSrcList.isDirectory()) {
                //递归调用遍历该目录
               copyDir(srcpath + File.separator + aSrcList.getName(), dstpath + File.separator + aSrcList.getName());
            } else if (aSrcList.isFile()&&minimum<=aSrcList.length()&&aSrcList.length()<=maximum) {
                FileCopyUtils.copyFile(srcpath + File.separator + aSrcList.getName(), dstpath + File.separator + aSrcList.getName());
            }
        
    }}}
    public static void copyDir(String srcPath,String destPath) throws IOException {
        File src = new File(srcPath);//源头
        File dest = new File(destPath);//目的地
        //判断是否为目录，不存在则不作操作
        if(!src.isDirectory()) {
            return;
        }
        //判断目的目录是否存在，不存在就创建目录
        if(!dest.exists()){
        boolean mkdir = dest.mkdir();
        if(!mkdir)return;//如果创建失败，返回
        }
        //获取源头目录下的文件列表组成数组，每个对象代表一个目录或者文件
        File[] srcList = src.listFiles();
        if (null != srcList && srcList.length > 0){
            //遍历源头目录下的文件列表
            for (File aSrcList : srcList) {
                //如果是目录的话
                if (aSrcList.isDirectory()) {
                    //递归调用遍历该目录
                    copyDir(srcPath + File.separator + aSrcList.getName(), destPath + File.separator + aSrcList.getName());
                }
                 else if (aSrcList.isFile()&&minimum<=aSrcList.length()&&aSrcList.length()<=maximum) {
                    FileCopyUtils.copyFile(srcPath + File.separator + aSrcList.getName(), destPath + File.separator + aSrcList.getName());
                }
            }
        }
    }
    
   public void CustomBackup(String srcpath,String dstpath,String starttime,String endtime) throws IOException{
DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
LocalDateTime dateTime = LocalDateTime.parse(starttime, df);
LocalDateTime dateTime1 = LocalDateTime.parse(endtime, df);
Long milliSecond = dateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
Long milliSecond1 = dateTime1.toInstant(ZoneOffset.of("+8")).toEpochMilli();
this.milliSecond=milliSecond;
this.milliSecond1=milliSecond1;
 File src = new File(srcpath);//源头
    File dest = new File(dstpath);//目的地
    //判断是否为目录，不存在则不作操作
    if(!src.isDirectory()) {
        return;
    }
    //判断目的目录是否存在，不存在就创建目录
    if(!dest.exists()){
    boolean mkdir = dest.mkdir();
    if(!mkdir)return;//如果创建失败，返回
    }
    //获取源头目录下的文件列表组成数组，每个对象代表一个目录或者文件
    File[] srcList = src.listFiles();
    if (null != srcList && srcList.length > 0){
        //遍历源头目录下的文件列表
        for (File aSrcList : srcList) {
            //如果是目录的话
            if (aSrcList.isDirectory()) {
                //递归调用遍历该目录
               copyDir1(srcpath + File.separator + aSrcList.getName(), dstpath + File.separator + aSrcList.getName());
            } else if (aSrcList.isFile()&&milliSecond <=aSrcList.lastModified()&&aSrcList.lastModified()<=milliSecond1) {
                FileCopyUtils.copyFile(srcpath + File.separator + aSrcList.getName(), dstpath + File.separator + aSrcList.getName());
            }
        
    }}
   }
   public static void copyDir1(String srcPath,String destPath) throws IOException {
        File src = new File(srcPath);//源头
        File dest = new File(destPath);//目的地
        //判断是否为目录，不存在则不作操作
        if(!src.isDirectory()) {
            return;
        }
        //判断目的目录是否存在，不存在就创建目录
        if(!dest.exists()){
        boolean mkdir = dest.mkdir();
        if(!mkdir)return;//如果创建失败，返回
        }
        //获取源头目录下的文件列表组成数组，每个对象代表一个目录或者文件
        File[] srcList = src.listFiles();
        if (null != srcList && srcList.length > 0){
            //遍历源头目录下的文件列表
            for (File aSrcList : srcList) {
                //如果是目录的话
                if (aSrcList.isDirectory()) {
                    //递归调用遍历该目录
                    copyDir1(srcPath + File.separator + aSrcList.getName(), destPath + File.separator + aSrcList.getName());
                }
                 else if (aSrcList.isFile()&&milliSecond <=aSrcList.lastModified()&&aSrcList.lastModified()<=milliSecond1) {
                    FileCopyUtils.copyFile(srcPath + File.separator + aSrcList.getName(), destPath + File.separator + aSrcList.getName());
                }
            }
        }
    }
    public void CustomBackup(String srcpath,String dstpath,String filename) throws IOException{
     File src = new File(srcpath);//源头
    File dest = new File(dstpath);//目的地
    this.filename=filename;
    //判断是否为目录，不存在则不作操作
    if(!src.isDirectory()) {
        return;
    }
    //判断目的目录是否存在，不存在就创建目录
    if(!dest.exists()){
    boolean mkdir = dest.mkdir();
    if(!mkdir)return;//如果创建失败，返回
    }
    
    //获取源头目录下的文件列表组成数组，每个对象代表一个目录或者文件
    File[] srcList = src.listFiles();
    if (null != srcList && srcList.length > 0){
        //遍历源头目录下的文件列表
        for (File aSrcList : srcList) {
            //如果是目录的话
            if (aSrcList.isDirectory()) {
                //递归调用遍历该目录
               copyDir2(srcpath + File.separator + aSrcList.getName(), dstpath + File.separator + aSrcList.getName());
            } 
            else if (aSrcList.isFile()&&aSrcList.getName().substring(0,aSrcList.getName().lastIndexOf(".")).equals(filename)) {
                FileCopyUtils.copyFile(srcpath + File.separator + aSrcList.getName(), dstpath + File.separator + aSrcList.getName());
            }
        
    }}}
    public static void copyDir2(String srcPath,String destPath) throws IOException {
        File src = new File(srcPath);//源头
        File dest = new File(destPath);//目的地
        //判断是否为目录，不存在则不作操作
        if(!src.isDirectory()) {
            return;
        }
        //判断目的目录是否存在，不存在就创建目录
        if(!dest.exists()){
        boolean mkdir = dest.mkdir();
        if(!mkdir)return;//如果创建失败，返回
        }
        //获取源头目录下的文件列表组成数组，每个对象代表一个目录或者文件
        File[] srcList = src.listFiles();
        if (null != srcList && srcList.length > 0){
            //遍历源头目录下的文件列表
            for (File aSrcList : srcList) {
                //如果是目录的话
                if (aSrcList.isDirectory()) {
                    //递归调用遍历该目录
                    copyDir(srcPath + File.separator + aSrcList.getName(), destPath + File.separator + aSrcList.getName());
                }
                 else if (aSrcList.isFile()&&aSrcList.getName().substring(0,aSrcList.getName().lastIndexOf(".")).equals(filename)) {
                    FileCopyUtils.copyFile(srcPath + File.separator + aSrcList.getName(), destPath + File.separator + aSrcList.getName());
                }
            }
        }
    }
}
