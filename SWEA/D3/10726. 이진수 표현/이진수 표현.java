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

            int temp = M;

            for (int i = 0; i < N; i++) {
                int bit = 1 << i;

                temp |= bit;
            }

            sb.append(String.format("#%d %s", t, temp == M ? "ON" : "OFF"))
                    .append('\n');
        }

        System.out.println(sb);
    }
}
