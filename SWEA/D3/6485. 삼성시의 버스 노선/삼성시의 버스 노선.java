import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, N, P;

    static int[] arr;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());


        for (int t = 1; t <= T; t++) {
            arr = new int[5002];

            N = Integer.parseInt(br.readLine());

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                arr[a] += 1;
                arr[b + 1] -= 1;
            }

            for (int i = 1; i <= 5001; i++) {
                arr[i] = arr[i - 1] + arr[i];
            }

            P = Integer.parseInt(br.readLine());

            sb.append('#')
                    .append(t)
                    .append(' ');
            for (int i = 0; i < P - 1; i++) {
                int c = Integer.parseInt(br.readLine());
                sb.append(arr[c])
                        .append(' ');
            }
            int c = Integer.parseInt(br.readLine());
            sb.append(arr[c])
                    .append('\n');
        }

        System.out.println(sb);
    }
}