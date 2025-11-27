import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, N, K;
    static int answer;

    static int[] arr;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            answer = 0;
            arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            go(0, 0);

            sb.append('#')
                    .append(t)
                    .append(' ')
                    .append(answer)
                    .append('\n');
        }

        System.out.println(sb);
    }

    private static void go(int idx, int sum) {
        if (sum == K) {
            answer++;
            return;
        }

        if (idx == N || sum > K) {
            return;
        }

        go(idx + 1, sum + arr[idx]);
        go(idx + 1, sum);
    }
}
