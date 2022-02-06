import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class MultithreadingAufgabe {
    public static void main(String[] args) {
        class Counter {
            private double c = 0.0;
            void up() {
                for (int i = 0; i < 100; i++)
                    System.out.println(c++);
            }
            void down() {
                for (int i = 0; i < 100; i++)
                    System.out.println(c--);
            }
            double getC() {
                return c;
            }
        }
        ArrayList<Thread> pool = new ArrayList<>();
        ExecutorService es = Executors.newFixedThreadPool(10);
        Counter count = new Counter();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                count.up();
                count.down();
            });
            //es.submit(t);
            t.start();
            pool.add(t);
        }

        try {
            Thread.sleep(10);
            //System.out.println(es.awaitTermination(10, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (Thread t :
                pool) {
            try{
                //t.join();
                t.interrupt();
            } catch (Exception e){

            }
        }
        System.out.println("Schlusswert: " + count.getC());
    }
}