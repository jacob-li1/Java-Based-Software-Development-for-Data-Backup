public class FileRunner {

  public static void main(String[] args) throws Exception {
    FileMonitor fileMonitor = new FileMonitor(1000);
    fileMonitor.monitor("E:\\javamavenproject\\Javaproject\\test.txt", new FileListener());
    fileMonitor.start();
  }
}
