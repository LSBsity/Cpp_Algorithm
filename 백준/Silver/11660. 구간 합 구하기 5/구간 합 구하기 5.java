import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, N, M;
    static int[][] arr, ans;

    static int[][] pos = {
            {0, 0},
            {0, 0}
    };

    public static void main(String[] args) throws Exception {
        T = 1;

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new int[N + 1][N + 1];
            ans = new int[N + 1][N + 1];

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    ans[i][j] = ans[i - 1][j] + ans[i][j - 1] - ans[i - 1][j - 1] + arr[i][j];
                }
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int result = go(
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken())
                );

                sb.append(result)
                        .append('\n');
            }
        }

        System.out.println(sb);
    }

    private static int go(int x1, int y1, int x2, int y2) {
        return ans[x2][y2] - ans[x1 - 1][y2] - ans[x2][y1 - 1] + ans[x1 - 1][y1 - 1];
    }
}