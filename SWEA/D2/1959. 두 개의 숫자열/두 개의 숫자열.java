import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, N, M;

    static int max;

    static int[] a, b;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            a = new int[N];
            b = new int[M];
            max = 0x80000000;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            go();

            sb.append('#')
                    .append(t)
                    .append(' ')
                    .append(max)
                    .append('\n');
        }

        System.out.println(sb);
    }


    private static void go() {
        int maxLen = Math.max(N, M);
        int minLen = Math.min(N, M);

        for (int i = 0; i < maxLen - minLen + 1; i++) {
            int sum = 0;
            for (int j = 0; j < minLen; j++) {
                if (maxLen == N) {
                    sum += b[j] * a[i + j];
                } else {
                    sum += a[j] * b[i + j];
                }
            }
            max = Math.max(max, sum);
        }
    }
}