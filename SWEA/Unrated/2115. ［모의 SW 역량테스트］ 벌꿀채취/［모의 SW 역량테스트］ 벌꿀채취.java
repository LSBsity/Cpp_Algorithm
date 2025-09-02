import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static StringBuilder sb = new StringBuilder();

    static int N, M, C;
    static int[][] map;
    static int[][] maxProfit;

    public static void main(String[] args) throws Exception {

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            maxProfit = new int[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c <= N - M; c++) {
                    int[] arr = new int[M];
                    for (int k = 0; k < M; k++) {
                        arr[k] = map[r][c + k];
                    }
                    maxProfit[r][c] = calcMaxProfit(arr);
                }
            }

            int answer = 0;
            for (int r1 = 0; r1 < N; r1++) {
                for (int c1 = 0; c1 <= N - M; c1++) {
                    for (int r2 = r1; r2 < N; r2++) {
                        for (int c2 = 0; c2 <= N - M; c2++) {
                            if (r1 == r2) {
                                if (!overlap(c1, c2)) {
                                    answer = Math.max(answer, maxProfit[r1][c1] + maxProfit[r2][c2]);
                                }
                            } else {
                                answer = Math.max(answer, maxProfit[r1][c1] + maxProfit[r2][c2]);
                            }
                        }
                    }
                }
            }

            sb.append('#').append(t).append(' ').append(answer).append('\n');
        }

        System.out.println(sb);
    }

    private static int calcMaxProfit(int[] arr) {
        int max = 0;
        int len = arr.length;

        for (int mask = 1; mask < (1 << len); mask++) {
            int sum = 0, profit = 0;
            for (int i = 0; i < len; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += arr[i];
                    profit += arr[i] * arr[i];
                }
            }
            if (sum <= C)
                max = Math.max(max, profit);
        }
        return max;
    }

    private static boolean overlap(int c1, int c2) {
        return !(c1 + M <= c2 || c2 + M <= c1);
    }
}