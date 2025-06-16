import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); 

        for (int i = 0; i < T; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();

            System.out.println(getPointCount(x1, y1, r1, x2, y2, r2));
        }

        sc.close();
    }

    public static int getPointCount(int x1, int y1, int r1, int x2, int y2, int r2) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        int distanceSq = dx * dx + dy * dy; 

        int sumR = r1 + r2;
        int diffR = Math.abs(r1 - r2);

        int sumRSq = sumR * sumR;
        int diffRSq = diffR * diffR;

        if (distanceSq == 0) {
            if (r1 == r2) {
                return -1; 
            } else {
                return 0;
            }
        } else {
            if (distanceSq == sumRSq || distanceSq == diffRSq) {
                return 1;
            } else if (diffRSq < distanceSq && distanceSq < sumRSq) {
                return 2; 
            } else {
                return 0; 
            }
        }
    }
}
