import java.time.LocalDate;

public class FreeStyleChecking {
    public static void main(String[] args){
        LocalDate date = LocalDate.of(2019,8,19);
        LocalDate date2 = LocalDate.of(2019,9,19);
        LocalDate date3 = LocalDate.of(LocalDate.now().getYear()-20,LocalDate.now().getMonth(),LocalDate.now().getDayOfMonth());
        System.out.println(date3);
    }
}
