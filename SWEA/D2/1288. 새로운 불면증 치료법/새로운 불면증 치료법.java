import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, N;
    static int max = 2046; // 1111111110

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            int sheep = N;

            int bit = 0;
            int cnt = 0;
            while (bit != max) {
                int temp = sheep;
                while (temp != 0) {
                    int rem = temp % 10;
                    temp /= 10;

                    bit |= 1 << rem + 1;
                }
                sheep += N;
                cnt++;
            }

            sb.append('#')
                    .append(t)
                    .append(' ')
                    .append(cnt * N)
                    .append('\n');
        }

        System.out.println(sb);
    }

}