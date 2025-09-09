import java.io.*;
import java.util.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;

    static StringBuilder sb = new StringBuilder();

    static int T, N, M;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            int[] LIS = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int max = 0;
            for (int i = 0; i < N; i++) {
                LIS[i] = 1;

                for (int j = 0; j < i; j++) {
                    if (arr[j] < arr[i] && LIS[i] < LIS[j] + 1) {
                        LIS[i] = LIS[j] + 1;
                    }
                }

                max = Math.max(max, LIS[i]);
            }
            sb.append('#')
                    .append(t)
                    .append(' ')
                    .append(max)
                    .append('\n');
        }

        System.out.println(sb);
        br.close();
    }

}