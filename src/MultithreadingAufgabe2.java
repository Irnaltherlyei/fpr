import java.util.ArrayList;
import java.util.List;


public class MultithreadingAufgabe2 {
    public static void main(String[] args) {
        class Counter {
            private double c = 0.0;
            void up() {
                for (int i = 0; i < 100; i++){
                    System.out.println(c++);
                    if(Thread.interrupted()){
                        // Wenn die Flag im Mainthread gesetzt wurde, wird das hierdurch direkt beendet.
                        // Ansonsten würde wahrscheinlich noch die for-Schleife durchlaufen da .terminate() versucht den Thread sicher zu beenden.
                        return;
                    }
                }

            }
            void down() {
                for (int i = 0; i < 100; i++){
                    System.out.println(c--);
                    if(Thread.interrupted()){
                        return;
                    }
                }
            }
            double getC() {
                return c;
            }
        }

        List<Thread> pool = new ArrayList<>();
        Counter count = new Counter();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                count.up();
                count.down();
            });
            t.start();
            pool.add(t);
        }

        try {
            Thread.sleep(10);
            for (Thread t :
                    pool) {
                // Thread soll abgebrochen werden.
                t.interrupt();
                // Da der Thread abgebrochen wurde, kann hier das Programm warten damit die Ausgabe sicher am Ende erscheint.
                t.join();
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Schlusswert: " + count.getC());
    }
}