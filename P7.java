import java.util.concurrent.Semaphore;

public class P7 {
    static Semaphore readLock = new Semaphore(1);
    static Semaphore writeLock = new Semaphore(1);
    static int readCount = 0;

    static class Read implements Runnable {
        public void run() {
            try {
                // Acquire section
                readLock.acquire();
                readCount++;
                if (readCount == 1) {
                    writeLock.acquire();
                }
                readLock.release();

                System.out.println("Thread " + Thread.currentThread().getName() + " is READING.");
                Thread.sleep(1500);
                System.out.println("Thread " + Thread.currentThread().getName() + " has FINISHED READING");

                // Release section
                readLock.acquire();
                readCount--;
                if (readCount == 0) {
                    writeLock.release();
                }
                readLock.release();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static class Write implements Runnable {
        public void run() {
            try {
                writeLock.acquire();
                System.out.println("Thread " + Thread.currentThread().getName() + " is WRITING");
                Thread.sleep(2500);
                System.out.println("Thread " + Thread.currentThread().getName() + " has FINISHED WRITING");
                writeLock.release();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Read(), "Reader-1");
        Thread t2 = new Thread(new Write(), "Writer-1");
        Thread t3 = new Thread(new Read(), "Reader-2");
        Thread t4 = new Thread(new Write(), "Writer-2");

        t1.start();
        t3.start();
        t2.start();
        t4.start();
    }
}