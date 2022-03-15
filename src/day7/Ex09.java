package day7;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Ex09 {
    public static void main(String[] args) {
        Ex09 i = new Ex09();
        i.cal();
    }

    private void cal() {
        LocalDateTime dt = LocalDateTime.now();

        // 1초를 더하는 여러가지 방법
        LocalDateTime dt2 = dt.minus(1L, ChronoUnit.SECONDS);
        LocalDateTime dt3 = dt.minusSeconds(1L);
        LocalDateTime dt4 = dt.minus(Duration.ofSeconds(1));

        System.out.println(dt);
        System.out.println(dt2);
        System.out.println(dt3);
        System.out.println(dt4);
    }
}
