import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, N;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N + 1][N + 1];
            arr[0][0] = 1;

			sb.append('#')
                .append(t)
                .append('\n');
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= i; j++) {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                    sb.append(arr[i][j])
                            .append(' ');
                }
                sb.append('\n');
            }
        }

        System.out.println(sb);
    }
}