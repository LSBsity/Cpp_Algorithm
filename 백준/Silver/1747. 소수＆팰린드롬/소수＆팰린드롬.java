import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int size = 2_000_000;
        boolean[] isPrime = new boolean[size + 1];

        isPrime[0] = isPrime[1] = true;
        for (int i = 2; i * i <= size; i++) {
            if (!isPrime[i]) {
                for (int j = i * i; j <= size; j += i) {
                    isPrime[j] = true;
                }
            }
        }

        for (int i = T; i <= size; i++) {
            if (!isPrime[i]) {
                StringBuilder sb1 = new StringBuilder(String.valueOf(i));
                StringBuilder reversed = new StringBuilder(String.valueOf(i)).reverse();
                if (sb1.toString().contentEquals(reversed)) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
