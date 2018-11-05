import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input numbers from 0 to 1000");
        String txt = String.valueOf(scan.nextInt());
        char [] array = txt.toCharArray();
        int sum = 0;
        for (char c : array)
            if (Character.isDigit(c)) {
                sum = sum + Character.getNumericValue(c);
            }
        System.out.println ("Sum = " + sum);
        scan.close();
    }
}
