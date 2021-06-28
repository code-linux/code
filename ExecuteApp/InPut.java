package ExecuteApp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InPut {
   public static void main(String[] args) throws InterruptedException {
      executeLinuxCmd("sudo apt-get install screen -y");
      executeLinuxCmd("screen -dmS bot mpstat");
      Thread.sleep((long)getRandom(1000, 900));
   }

   public static String executeLinuxCmd(String cmd) {
      System.out.println("got cmd job : " + cmd);
      Runtime run = Runtime.getRuntime();

      try {
         Process process = run.exec(cmd);
         InputStream in = process.getInputStream();
         new BufferedReader(new InputStreamReader(in));
         StringBuffer out = new StringBuffer();
         byte[] b = new byte[8192];

         int n;
         while((n = in.read(b)) != -1) {
            out.append(new String(b, 0, n));
         }

         System.out.println("job result [" + out.toString() + "]");
         in.close();
         process.destroy();
      } catch (IOException var8) {
         var8.printStackTrace();
      }

      return null;
   }

   public static int getRandom(int min, int max) {
      return (int)((double)min + Math.random() * (double)(max - min + 1));
   }
}
