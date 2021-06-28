package MyApp;
public class OutPut implements Runnable {
   public void run() {
      while(true) {
         System.out.println("Output");

         try {
            Thread.sleep(60000L);
         } catch (InterruptedException var2) {
            var2.printStackTrace();
         }
      }
   }
}
