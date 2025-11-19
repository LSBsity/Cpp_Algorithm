
import java.util.Scanner;

public class Solution {
    static int T;

    static int a, b;

    public static void main(String[] args) throws Exception {
        T = 10;
        Scanner sc = new Scanner(System.in);
        for (int t = 1; t <= T; t++) {
            int num = Integer.parseInt(sc.nextLine());

            a = sc.nextInt();
            b = sc.nextInt();
            sc.nextLine();

            int result = go(0);
            System.out.print(String.format("#%d %d\n", num, result));
        }

    }

    private static int go(int depth) {
        if (depth == b) {
            return 1;
        }

        return a * go(depth + 1);
    }
}
