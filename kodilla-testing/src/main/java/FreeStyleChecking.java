import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class FreeStyleChecking {
    public static void main(String[] args){
        LocalDate date = LocalDate.of(2019,8,19);
        LocalDate date2 = LocalDate.of(2019,9,17);
        double date3 = DAYS.between(date,date2);
        System.out.println(date3);


    }
}
