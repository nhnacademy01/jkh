package day7;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Ex10 {
    public static void main(String[] args) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();

        LocalDateTime dt1 = LocalDateTime.ofInstant(date.toInstant(), ZoneOffset.UTC);
        OffsetDateTime odt1 = OffsetDateTime.ofInstant(cal.toInstant(), ZoneId.systemDefault());
        ZonedDateTime zdt1 = ZonedDateTime.ofInstant(cal.toInstant(), ZoneId.systemDefault());

        System.out.println(date + " " + date.getTimezoneOffset());
        System.out.println(cal.getTime() + " " + cal.getTimeZone().getID());
        System.out.println(dt1);
        System.out.println(odt1);
        System.out.println(zdt1);
        Ex10  i = new Ex10();
        i.format();
    }

    private void format() {
        String input = "1980-01-01 16:16:16";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime date = LocalDateTime.parse(input, formatter); //파싱
        System.out.println(date);

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String output = date.format(format); //포멧팅
        System.out.println(output);
    }
}
