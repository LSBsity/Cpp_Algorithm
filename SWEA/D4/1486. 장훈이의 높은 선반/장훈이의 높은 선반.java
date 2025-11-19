import java.io.*;
import java.util.*;

public class Solution {

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, N, B;
    static int[] arr;

    static int bestDiff; // (sum - B)의 최소값

    public static void main(String[] args) throws Exception {

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            bestDiff = Integer.MAX_VALUE; // 매우 큰 값으로 초기화

            go(0, 0);

            sb.append('#').append(t).append(' ').append(bestDiff).append('\n');
        }

        System.out.println(sb);
    }

    static void go(int idx, int currentSum) {
        if (currentSum >= B) {
            bestDiff = Math.min(bestDiff, currentSum - B);
        }

        if (idx == N) return;

        go(idx + 1, currentSum + arr[idx]);
        go(idx + 1, currentSum);
    }
}