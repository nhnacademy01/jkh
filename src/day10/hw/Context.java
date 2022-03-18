package day10.hw;

import java.util.Random;

public class Context {

    public static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> new Random().nextInt(100));
    public static int normal = new Random().nextInt(100);
}
   class Ex01 {

        private final String threadName;

        public Ex01(String threadName) {
            this.threadName = threadName;

        }

        public void ex01() {

            System.out.println("ex01 class " + threadName + " = " + Context.threadLocal.get());


        }

    }




