import java.io.*;
import java.util.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static StringBuilder sb = new StringBuilder();

    static int T;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        int bit = (1 << 10) - 1;

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            int count = 0;
            int check = 0;

            for (count = 1;; count++) {
                char[] chars = String.valueOf(N * count).toCharArray();

                for (char c : chars) {
                    int num = c - '0';

                    check |= (1 << num);
                }

                if (bit == check)
                    break;
            }

            sb.append(String.format("#%d %d", t, N * count))
                    .append('\n');
        }
        
        System.out.println(sb);
    }

}
