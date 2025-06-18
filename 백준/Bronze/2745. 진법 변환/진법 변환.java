import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.next(); 
        int b = scanner.nextInt(); 
        scanner.close();

        long result = 0;
        int len = n.length();

        for (int i = 0; i < len; i++) {
            char c = n.charAt(i);
            int value;

            if (c >= '0' && c <= '9') {
                value = c - '0';
            } else { 
                value = c - 'A' + 10;
            }

            result = result * b + value;
        }

        System.out.println(result);
    }
}
