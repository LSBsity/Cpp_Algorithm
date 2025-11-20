import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, N, K;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;

            for (int i = 0; i < N; i++) {
                int cnt = 0;
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 1) cnt++;
                    else {
                        if (cnt == K) answer++;
                        cnt = 0;
                    }
                }
                if (cnt == K) answer++;
            }

            for (int j = 0; j < N; j++) {
                int cnt = 0;
                for (int i = 0; i < N; i++) {
                    if (map[i][j] == 1) cnt++;
                    else {
                        if (cnt == K) answer++;
                        cnt = 0;
                    }
                }
                if (cnt == K) answer++;
            }

            sb.append("#")
                    .append(t)
                    .append(" ")
                    .append(answer)
                    .append("\n");
        }

        System.out.print(sb);
    }

}
