package day9;

public class Ex07 {
    public static void main(String[] args) {
        Thread tick = new Thread(new Tick());
        Thread tock = new Thread(new Tock());
        tick.start();
        tock.start();
    }
}
class Tick implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.print("Tick ");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
        }
    }
}

class Tock implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        // TODO 직접 구현해주세요.
        for (int i = 0; i < 5; i++) {
            System.out.print("Tock ");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
        }
    }
}