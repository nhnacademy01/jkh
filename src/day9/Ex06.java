package day9;

public class Ex06 {
    public static void main(String[] args) {
        System.out.println("Before call thread");
        new Thread(new ExceptionalRunner()).start();
//        new ExceptionalRunner().run();    // 이 주석을 제거하면?
        System.out.println("After call thread");

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.print("Tick ");
            } else {
                System.out.print("Tock ");
            }
            try {
                Thread.sleep(1000);     // 1초 동안 잠들어요
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ExceptionalRunner implements Runnable {
    @Override
    public void run() {
        throw new RuntimeException("Unknown Exception.");
    }
}

