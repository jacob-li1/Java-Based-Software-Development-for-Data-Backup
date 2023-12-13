import java.io.File;
import java.io.IOException;
public class FileCopy {
    public void copy(String srcPath,String dstPath) throws IOException {
        try {
            File file=new File(srcPath);
            if(file.isDirectory()){
                delete(dstPath);
                FileCopyUtils.copyDir(srcPath,dstPath);//静态方法，用类名调用
            }
            else {
                File f=new File(dstPath);
                if(!f.exists()){
                    f.createNewFile();
                }
                FileCopyUtils.copyFile(srcPath,dstPath);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void delete(String path) {
		// 为传进来的路径参数创建一个文件对象
		File file = new File(path);
		// 如果目标路径是一个文件，那么直接调用delete方法删除即可
		// file.delete();
		// 如果是一个目录，那么必须把该目录下的所有文件和子目录全部删除，才能删除该目标目录，这里要用到递归函数
		// 创建一个files数组，用来存放目标目录下所有的文件和目录的file对象
		File[] files = new File[50];
		// 将目标目录下所有的file对象存入files数组中
		files = file.listFiles();
		// 循环遍历files数组
		for(File temp : files){
			// 判断该temp对象是否为文件对象
			if (temp.isFile()) {
				temp.delete();
			}
			// 判断该temp对象是否为目录对象
			if (temp.isDirectory()) {
				// 将该temp目录的路径给delete方法（自己），达到递归的目的
				delete(temp.getAbsolutePath());
				// 确保该temp目录下已被清空后，删除该temp目录
                temp.delete();
			}
		}
	}

    public void compress(String srcPath,String dstPath){
        try {
            FileZipUtil.compressFile(srcPath,dstPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void unzip(String srcPath, String dstPath) throws Exception {
        try {
            UnZipUtil.unzip(srcPath,dstPath);
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public void encrypt(String srcPath,String dstPath,int key) throws IOException {
            try {
                File file=new File(srcPath);
                if(file.isDirectory()){
                    FileEncryptUtils.search(srcPath,dstPath, key);
                }
                else {
                    File f=new File(dstPath);
                    if(!f.exists()){
                        f.createNewFile();
                    }
                    FileEncryptUtils.encrypt(srcPath,dstPath,key);
                }
            }catch (IOException e){
                e.printStackTrace();
            }
    }

    public void decrypt(String srcPath,String dstPath,int key) throws IOException {
        try {
                File file=new File(srcPath);
                if(file.isDirectory()){
                    FileEncryptUtils.search2(srcPath,dstPath, key);
                }
                else {
                    File f=new File(dstPath);
                    if(!f.exists()){
                        f.createNewFile();
                    }
                    FileEncryptUtils.decrypt(srcPath,dstPath,key);
                }
            }catch (IOException e){
                e.printStackTrace();
            }
    }

    public  void RegularBackup(String srcpath,String dstpath,long time_interval) throws IOException{
     try{
        RegularBackup regularBackup=new RegularBackup();
        regularBackup.RegularBackup(srcpath, dstpath, time_interval);
    }catch (IOException e){
        e.printStackTrace();
    }
    }

    public  void RealtimeBackup(String srcpath,String dstpath,long interval) throws Exception{
     
        FileMonitor fileMonitor = new FileMonitor(interval);
        FileListener.setter(srcpath,dstpath);
        fileMonitor.monitor(srcpath, new FileListener());
        fileMonitor.start();
    }
public  void CustomBackup(String srcpath,String dstpath) throws Exception{
    CustomBackup c=new CustomBackup();
    c.CustomBackup(srcpath, dstpath);
    }
    public  void CustomBackup(String srcpath,String dstpath,long minimum,long maximum) throws Exception{
    CustomBackup c=new CustomBackup();
    c.CustomBackup(srcpath, dstpath,minimum, maximum);
    }
     public  void CustomBackup(String srcpath,String dstpath,String starttime,String endtime) throws Exception{
    CustomBackup c=new CustomBackup();
    c.CustomBackup(srcpath, dstpath,starttime,endtime);
    }
     public  void CustomBackup(String srcpath,String dstpath,String filename) throws Exception{
    CustomBackup c=new CustomBackup();
    c.CustomBackup(srcpath, dstpath,filename);
    }
    public void varify(String firstpath,String secondpath) throws IOException {
        varifyUtils first=new varifyUtils();
        varifyUtils second=new varifyUtils();
        first.search(firstpath,firstpath);
        second.search(secondpath,secondpath);

//        System.out.println(first.map);
//        System.out.println(second.map);
//        if (first.map.equals(second.map)){
//            System.out.println(true);
//        }else {
//            System.out.println(false);
//        }
    }
}

