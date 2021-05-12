package indi.lean.acm.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreeThreadPrintABC {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock(true);
        Task a = new Task(lock, "A");
        Task b = new Task(lock, "B");
        Task c = new Task(lock, "C");
        new Thread(a).start();
        new Thread(b).start();
        new Thread(c).start();
    }



}
class Task implements Runnable {
    private final String character;
    private final Lock lock;

    public Task(Lock lock, String character) {
        this.lock = lock;
        this.character = character;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            lock.lock();
            try {
                System.out.println(character);
            } finally {
                lock.unlock();
            }
        }
    }
}
