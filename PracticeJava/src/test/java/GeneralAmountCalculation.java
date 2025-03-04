import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class cushypay {

    public static void main(String[] args) {
        double TransferAmount, fixed, amount1, amount2;
        int convenience, Tax, Platform_charges;

        System.out.println("Enter the Transfer amount");
        Scanner sc = new Scanner(System.in);
        TransferAmount = sc.nextDouble();

        System.out.println("Enter the convenience amount");
        Scanner sc1 = new Scanner(System.in);
        convenience = sc1.nextInt();

        System.out.println("Enter the ( SGST + CGST ) amount");
        Scanner sc2 = new Scanner(System.in);
        Tax = sc2.nextInt();

        System.out.println("Enter the platform amount");
        Scanner sc4 = new Scanner(System.in);
        Platform_charges = sc4.nextInt();

        System.out.println("Enter the fixed amount");
        Scanner sc3 = new Scanner(System.in);
        fixed = sc3.nextDouble();


        double convenience1 = twoDecimelDouble((TransferAmount * convenience) / 100);
        double Platform_charges1 =twoDecimelDouble ((TransferAmount * Platform_charges) / 100);


        amount1 = twoDecimelDouble((convenience1 + Platform_charges1) * Tax / 100);
        amount2 =twoDecimelDouble (amount1 + TransferAmount + convenience1 + Platform_charges1);

        System.out.println("convenience Charges " + convenience1);

        System.out.println("Platform Charges " + Platform_charges1);

        System.out.println("Amount of Convenience +Platform with GST calculated Values  " + amount1);

        System.out.println("Transferrable Amount " + amount2);


    }

    public static double twoDecimelDouble(double value) {
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP); // Rounds to 2 decimal places

        double roundedValue = bd.doubleValue();
        return roundedValue;
    }
}