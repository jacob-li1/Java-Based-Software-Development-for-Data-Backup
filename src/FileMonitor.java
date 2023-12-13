import java.io.File;

import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.HiddenFileFilter;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

public class FileMonitor {

  private FileAlterationMonitor monitor;

  public FileMonitor(long interval) {
    monitor = new FileAlterationMonitor(interval);
  }

  /**
   * 给文件添加监听
   *
   * @param path     文件路径
   * @param listener 文件监听器
   */
  public void monitor(String path, FileAlterationListener listener) {
    // IOFileFilter directories = FileFilterUtils.and(
    //     // 只监听文件夹、目录
    //     FileFilterUtils.directoryFileFilter(),
    //     // 此过滤器接受File隐藏的
    //     HiddenFileFilter.VISIBLE);
    // IOFileFilter files   = FileFilterUtils.and(
    //     // 只监听文件
    //     FileFilterUtils.fileFileFilter(),
    //     // 只监听文件后缀为txt的文件
    //     FileFilterUtils.suffixFileFilter(".txt"));
    // IOFileFilter filter = FileFilterUtils.or(directories, files);

    FileAlterationObserver observer = new FileAlterationObserver(new File(path));
    monitor.addObserver(observer);
    observer.addListener(listener);
  }

  public void stop() throws Exception {
    monitor.stop();
  }

  public void start() throws Exception {
    monitor.start();

  }
}
