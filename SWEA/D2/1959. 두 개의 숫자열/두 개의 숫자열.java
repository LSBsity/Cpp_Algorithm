import java.io.*;
import java.util.*;

class Solution {

    static int[] arr = new int[200];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] a = new int[n];
            int[] b = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            int max = Integer.MIN_VALUE;

            if (n < m) { // 두번쨰가 더 길면
                for (int i = 0; i <= m - n; i++) { // 0 ~ n, 1 ~ n + 1
                    int sum = 0;
                    for (int j = i; j < i + n; j++) {
                        sum += b[j] * a[j - i];
                    }
                    max = Math.max(max, sum);
                }
            } else if (n > m) {
                for (int i = 0; i <= n - m; i++) { // 0 ~ n, 1 ~ n + 1
                    int sum = 0;
                    for (int j = i; j < i + m; j++) {
                        sum += a[j] * b[j - i];
                    }
                    max = Math.max(max, sum);
                }
            } else {
                int sum = 0;
                for (int i = 0; i < n; i++) {
                    sum += a[i] * b[i];
                }
                max = sum;
            }
            System.out.printf("#%d %d\n", t, max);
        }
    }
}
