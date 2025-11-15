import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, N;

    static char[][] chars;

    public static void main(String[] args) throws Exception {
        T = 10;

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            chars = new char[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    chars[i][j] = st.nextToken().charAt(0);
                }
            }

            int result = go();
            sb.append('#')
                    .append(t)
                    .append(' ')
                    .append(result)
                    .append('\n');
        }

        System.out.println(sb);
    }

    private static int go() {
        int cnt = 0;

        for (int col = 0; col < N; col++) {
            boolean started = false;

            for (int row = 0; row < N; row++) {
                if (chars[row][col] == '1') {
                    started = true;
                } else if (chars[row][col] == '2') {
                    if (started) {
                        cnt++;
                        started = false;
                    }
                }
            }
        }

        return cnt;
    }
}
