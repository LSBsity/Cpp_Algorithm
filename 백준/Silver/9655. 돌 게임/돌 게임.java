import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        boolean[] dp = new boolean[1001];

        dp[1] = true;
        if (size >= 2) dp[2] = false;
        if (size >= 3) dp[3] = true;

        for (int i = 4; i <= size; i++) {
            dp[i] = !dp[i - 1] || !dp[i - 3];
        }

        System.out.println(dp[size] ? "SK" : "CY");
        br.close();
    }
}


