import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, N;

    static int[] num;
    static int[] cnt = new int[4]; // + - * / 각각의 개수

    static int max, min;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            num = new int[N];

            max = 0x80000000;
            min = 0x7fffffff;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                cnt[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            dfs(1, num[0]);

            sb.append('#')
                    .append(t)
                    .append(' ')
                    .append(max - min)
                    .append('\n');
        }

        System.out.println(sb);
    }

    private static void dfs(int idx, int sum) {
        if (idx == N) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (cnt[i] == 0) continue;

            cnt[i]--;

            switch (i) {
                case 0:
                    dfs(idx + 1, sum + num[idx]);
                    break;
                case 1:
                    dfs(idx + 1, sum - num[idx]);
                    break;
                case 2:
                    dfs(idx + 1, sum * num[idx]);
                    break;
                case 3:
                    dfs(idx + 1, sum / num[idx]);
                    break;
            }

            cnt[i]++;
        }
    }
}
