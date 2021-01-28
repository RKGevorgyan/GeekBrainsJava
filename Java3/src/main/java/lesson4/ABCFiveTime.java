package lesson4;
public class ABCFiveTime {
    private final Object mon = new Object();
    private volatile int currentLetter = 1;

    public static void main(String[] args) {
        ABCFiveTime w = new ABCFiveTime();
        Thread t1 = new Thread(w::printA);
        Thread t2 = new Thread(w::printB);
        Thread t3 = new Thread(w::printC);
        t1.start();
        t2.start();
        t3.start();
    }

    public void printA() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 1) {
                        mon.wait();
                    }
                    System.out.print("A");
                    currentLetter = 2;
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 2) {
                        mon.wait();
                    }
                    System.out.print("B");
                    currentLetter = 3;
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void printC() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 3) {
                        mon.wait();
                    }
                    System.out.print("C");
                    currentLetter = 1;
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
