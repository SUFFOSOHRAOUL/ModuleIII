package DateTime;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateDiffCalculator {
    public static  String getDiff(LocalDate d1, LocalDate d2){
        Period period = d1.until(d2);

        String diffStr = "the difference is ";

        if (period.getYears() !=0){
            diffStr = diffStr + period.getYears() + " years, ";
        }
        if(period.getMonths() != 0){
            diffStr = diffStr+period.getMonths() + "months, ";

        }
        if (period.getDays() !=0){
            diffStr = diffStr + period.getDays() +" day(s)";
        }
        return diffStr;
    }
    public static  void main(String s[]){
        LocalDate todayDate = LocalDate.now();
        DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("\n The date is " + todayDate.format(dateformat));
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input the date in dd/MM/yyyy format");
        String rawDate = scanner.nextLine();
        try{
            LocalDate givenDate = LocalDate.parse(rawDate, dateformat);

            System.out.println("\n The given date is " + givenDate.format(dateformat))
            ;
            if(givenDate.isEqual(todayDate)){
                System.out.println("Both dates are the same");
            }else{
                if(givenDate.isBefore(todayDate)){
                    System.out.println(getDiff(givenDate,todayDate));
                }else{
                    System.out.println(getDiff(todayDate,givenDate));
                }

            }
        }catch(DateTimeException dte){
            System.out.println("Invalid Input. please try again!");
        }
    }
}