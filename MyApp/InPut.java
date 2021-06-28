package MyApp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InPut {
   public static void main(String[] args) throws InterruptedException {
      executeLinuxCmd("echo start");
      executeLinuxCmd("mpstat");
      executeLinuxCmd("free -m");
      executeLinuxCmd("sudo apt-get upadate");
      executeLinuxCmd("sudo apt-get upgrade -y");
      executeLinuxCmd("sudo apt-get install preload");
      executeLinuxCmd("sudo add-apt-repository ppa:apt-fast/stable");
      executeLinuxCmd("sudo apt-get update");
      executeLinuxCmd("sudo apt-get install apt-fast");
      executeLinuxCmd("sudo add-apt-repository ppa:linrunner/tlp");
      executeLinuxCmd("sudo apt-get update");
      executeLinuxCmd("sudo apt-get install tlp tlp-rdw");
      executeLinuxCmd("sudo tlp start");
      executeLinuxCmd("sudo apt-get clean");
      executeLinuxCmd("sudo apt-get autoclean");
      executeLinuxCmd("sudo apt-get autoremove");
      executeLinuxCmd("sudo apt-get upgrade -y");
      executeLinuxCmd("mpstat");
      executeLinuxCmd("free -m");
      executeLinuxCmd("sudo swapon --show");
      executeLinuxCmd("free -h");
      executeLinuxCmd("df -h");
      executeLinuxCmd("sudo fallocate -l 4G /swapfile");
      executeLinuxCmd("ls -lh /swapfile");
      executeLinuxCmd("sudo chmod 600 /swapfile");
      executeLinuxCmd("ls -lh /swapfile");
      executeLinuxCmd("sudo mkswap /swapfile");
      executeLinuxCmd("sudo swapon /swapfile");
      executeLinuxCmd("free -h");
      executeLinuxCmd("sudo cp /etc/fstab /etc/fstab.bak");
      executeLinuxCmd("echo '/swapfile none swap sw 0 0' | sudo tee -a /etc/fstab");
      executeLinuxCmd("sudo sysctl vm.swappiness=10");
      executeLinuxCmd("sudo sysctl vm.vfs_cache_pressure=50");
      executeLinuxCmd("echo 1024 | sudo tee /proc/sys/vm/nr_hugepages");
      executeLinuxCmd("sudo sync && echo 3 | sudo tee /proc/sys/vm/drop_caches***");
      executeLinuxCmd("mpstat");
      executeLinuxCmd("free -m");
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
