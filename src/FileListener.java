
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationObserver;
public class FileListener extends FileAlterationListenerAdaptor {
static String srcpath,dstpath;
public static void setter(String a,String b){
    srcpath=a;
    dstpath=b;
}
  @Override
  public void onStart(FileAlterationObserver observer) {
    super.onStart(observer);
    System.out.println("onStart");
  }

  @Override
  public void onDirectoryCreate(File directory) {
    System.out.println("create：" + directory.getAbsolutePath());
    FileCopy filecopy=new FileCopy();
    try {
        filecopy.copy(srcpath,dstpath);
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
  }

  @Override
  public void onDirectoryChange(File directory) {
    System.out.println("modify：" + directory.getAbsolutePath());
     FileCopy filecopy=new FileCopy();
    try {
        filecopy.copy(srcpath,dstpath);
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
  }

  @Override
  public void onDirectoryDelete(File directory) {
    System.out.println("delete：" + directory.getAbsolutePath());
     FileCopy filecopy=new FileCopy();
    try {
        filecopy.copy(srcpath,dstpath);
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
  }

  @Override
  public void onFileCreate(File file) {
    String compressedPath = file.getAbsolutePath();
    System.out.println("create：" + compressedPath);
    if (file.canRead()) {
      // TODO 读取或重新加载文件内容
      System.out.println("File changes, processing");
    }
     FileCopy filecopy=new FileCopy();
    try {
        filecopy.copy(srcpath,dstpath);
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
  }

  @Override
  public void onFileChange(File file) {
    String compressedPath = file.getAbsolutePath();
    System.out.println("modify：" + compressedPath);
     FileCopy filecopy=new FileCopy();
    try {
        filecopy.copy(srcpath,dstpath);
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
  }

  @Override
  public void onFileDelete(File file) {
    System.out.println("delete：" + file.getAbsolutePath());
     FileCopy filecopy=new FileCopy();
    try {
        filecopy.copy(srcpath,dstpath);
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
  }

  @Override
  public void onStop(FileAlterationObserver observer) {
    super.onStop(observer);
    System.out.println("onStop");
  }
}
