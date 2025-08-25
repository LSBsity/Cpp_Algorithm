import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;

    static StringBuilder sb = new StringBuilder();

    static int T;
    static int N, M;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            solve1(t, N, M);
            // solve2(t, N, M);
        }

        System.out.println(sb);
    }

    private static void solve1(int t, int N, int M) {
        int temp = M;

        for (int i = 0; i < N; i++) {
            int bit = 1 << i;

            temp |= bit;
        }

        sb.append(String.format("#%d %s", t, temp == M ? "ON" : "OFF"))
                .append('\n');
    }

    private static void solve2(int t, int N, int M) {
        int lastBit = (1 << N) - 1;
        
        if (lastBit == (M & lastBit)) {
            sb.append(String.format("#%d %s", t, "ON"));
        } else {
            sb.append(String.format("#%d %s", t, "OFF"));
        }
        sb.append('\n');
    }

}
