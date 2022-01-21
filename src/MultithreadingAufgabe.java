import java.util.*;

public class MultithreadingAufgabe {
    public static void main(String[] args) throws InterruptedException {
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
        ArrayList<Thread> threadPool = new ArrayList<Thread>();
        Counter count = new Counter();
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(() -> {
                count.up();
                count.down();
            });
            t.start();
            threadPool.add(t);
        }
        // Durch .join() wird das Hauptprogramm gestoppt bis jeder Thread beendet wurde.
        for (Thread t :
                threadPool) {
            t.join();
        }
        System.out.println("Schlusswert: " + count.getC());
    }
}