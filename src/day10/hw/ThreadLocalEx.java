package day10.hw;

public class ThreadLocalEx {
    static int ss= 0;
    public static void main(String[] args) {
        int mainTl = Context.threadLocal.get();

        System.out.println("main threadlocal "+mainTl);
        Thread first = new Thread(() -> {

            System.out.println("first thread  " + Context.threadLocal.get());
            day10.hw.Ex01 i = new day10.hw.Ex01("first thread ");

            i.ex01();
            ss += Context.threadLocal.get();
            System.out.println("first call main " +mainTl);
            System.out.println("public value "+ss);
            System.out.println("normal value" + Context.normal);
        });

        Thread second = new Thread(() -> {

            System.out.println("second thread  " + Context.threadLocal.get());
            day10.hw.Ex01 i2 = new Ex01("second thread ");
            i2.ex01();
            ss += Context.threadLocal.get();
            System.out.println("second call main " +mainTl);
            System.out.println("public value "+ss);
            System.out.println("normal value " + Context.normal);
        });

        first.start();
        second.start();

    }
}