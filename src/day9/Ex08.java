//package day9;
//
//public class Ex08 {
//    public static void main(String[] args) {
//        Ex08 o = new Ex08();
//        o.checkThreadState1();
//    }
//
//    public void checkThreadState1() {
//        SleepThread t = new SleepThread(2_000);  // 2초 동안 대기하는 스레드
//        try {
//            System.out.println("After new: " + t.getState());
//            t.start();  // 스레드 시작
//            System.out.println("After start: " + t.getState());
//            Thread.sleep(1_000);    // 스레드 Sleep 중
//            System.out.println("After 1 seconds: " + t.getState());
//            t.join();   // 스레드 종료 대기
////            t.join(500);    // 0.5초 동안 스레드 종료 대기
//            t.interrupt();    // 스레드 중지 요청
//            System.out.println("After join: " + t.getState());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private class SleepThread {
//    }
//}
