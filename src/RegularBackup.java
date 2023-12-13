import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class RegularBackup extends TimerTask{
    static String srcpath,dstpath;
    public  void RegularBackup(String srcpath,String dstpath,long timeinterval) throws IOException{
        this.srcpath=srcpath;
        this.dstpath=dstpath;
        Timer t=new Timer();
        RegularBackup task=new RegularBackup();
        t.scheduleAtFixedRate(task, 0,timeinterval*1000);
        
        }
@Override
public void run() {
    // TODO Auto-generated method stub
    try{
     FileCopy filecopy=new FileCopy();
     filecopy.copy(srcpath,dstpath);} catch (Exception e) {
    e.printStackTrace();
    throw new UnsupportedOperationException("Unimplemented method 'run'");
}}}
