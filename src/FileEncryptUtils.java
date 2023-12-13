import java.io.*;

public class FileEncryptUtils {
//    在复制目录的过程中判断源文件下所有文件对象是否为目录，是的话则利用递归调用自己复制目录
//    如果是文件的话，则调用encrypt方法加密文件

    public static void search(String srcPath,String destPath,int key) throws IOException {
        File src = new File(srcPath);//源头
        File dest = new File(destPath);//目的地
        //判断是否为目录，不存在则不作操作
        if(!src.isDirectory()) {
            return;
        }
        //判断目的目录是否存在，不存在就创建目录
        if(!dest.exists()) {
            dest.mkdir();
        }
        //获取源头目录下的文件列表组成数组，每个对象代表一个目录或者文件
        File[] srcList = src.listFiles();
        if (null != srcList && srcList.length > 0){
            //遍历源头目录下的文件列表
            for (File aSrcList : srcList) {
                //如果是目录的话
                if (aSrcList.isDirectory()) {
                    //递归调用遍历该目录
                    search(srcPath + File.separator + aSrcList.getName(), destPath + File.separator + aSrcList.getName(),key);
                } else if (aSrcList.isFile()) {
                    encrypt(srcPath + File.separator + aSrcList.getName(), destPath + File.separator + aSrcList.getName(),key);
                }
            }
        }
    }


    //    实现对文件的复制
    public static void encrypt(String isFile, String osFile, int key) throws IOException {
        BufferedInputStream is = null;
        BufferedOutputStream os = null;
        try {
            is = new BufferedInputStream(new FileInputStream(isFile));
            os = new BufferedOutputStream(new FileOutputStream(osFile));
            byte[] data = new byte[4096];//缓存容器

            int len;//接收长度

            while((len=is.read(data))!=-1) {
                for(int i=0;i<4096;i++){
                    data[i]+=(byte) key;
                }
                os.write(data, 0, len);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            //	释放资源 分别关闭 先打开的后关闭
            try {
                if(null!=os) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(null!=is) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void search2(String srcPath,String destPath,int key) throws IOException {
        File src = new File(srcPath);//源头
        File dest = new File(destPath);//目的地
        //判断是否为目录，不存在则不作操作
        if(!src.isDirectory()) {
            return;
        }
        //判断目的目录是否存在，不存在就创建目录
        if(!dest.exists()) {
            dest.mkdir();
        }
        //获取源头目录下的文件列表组成数组，每个对象代表一个目录或者文件
        File[] srcList = src.listFiles();
        if (null != srcList && srcList.length > 0){
            //遍历源头目录下的文件列表
            for (File aSrcList : srcList) {
                //如果是目录的话
                if (aSrcList.isDirectory()) {
                    //递归调用遍历该目录
                    search2(srcPath + File.separator + aSrcList.getName(), destPath + File.separator + aSrcList.getName(),key);
                } else if (aSrcList.isFile()) {
                    decrypt(srcPath + File.separator + aSrcList.getName(), destPath + File.separator + aSrcList.getName(),key);
                }
            }
        }
    }

    public static void decrypt(String isFile, String osFile, int key) throws IOException{
        BufferedInputStream is = null;
        BufferedOutputStream os = null;
        try {
            is = new BufferedInputStream(new FileInputStream(isFile));
            os = new BufferedOutputStream(new FileOutputStream(osFile));
            byte[] data = new byte[4096];//缓存容器

            int len;//接收长度

            while((len=is.read(data))!=-1) {
                for(int i=0;i<4096;i++){
                    data[i]-=(byte) key;
                }
                os.write(data, 0, len);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            //	释放资源 分别关闭 先打开的后关闭
            try {
                if(null!=os) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(null!=is) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}