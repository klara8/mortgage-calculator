import java.sql.SQLSyntaxErrorException;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;


        Scanner scanner = new Scanner(System.in);

        int principal = 0;

    while (true){
        System.out.print("Principal (1K Kč - 1M Kč): ");
        principal = scanner.nextInt();
        if (principal >= 1000 && principal <= 1000000)
            break;
        System.out.println("Vlož hodnotu mezi 1 000 a 1 000 000.");
    }

        float annualInterestRate = 0;
        float monthlyInterestRate = 0;


    while (true) {
        System.out.print("Annual Interest Rate: ");
        annualInterestRate = scanner.nextFloat();
        if (annualInterestRate > 0 && annualInterestRate < 30) {
             monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR / PERCENT;
            break;
        }
        System.out.println("Vložte číslo od 0 do 30.");
    }


        int periodInMonths = 0;
        int period = 0;

    while(true){
        System.out.print("Period (Years): ");
        period = scanner.nextInt();
        if(period > 1 && period < 30){
            periodInMonths = period * MONTHS_IN_YEAR;
            break;
        }
        System.out.println("Vložte číslo mezi 1 a 30.");
    }

        double mortgage = principal
                * monthlyInterestRate
                * Math.pow((1 + monthlyInterestRate), periodInMonths) / (Math.pow((1 + monthlyInterestRate), periodInMonths) - 1);

        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("Mortgage: " + formattedMortgage);
    }
}


