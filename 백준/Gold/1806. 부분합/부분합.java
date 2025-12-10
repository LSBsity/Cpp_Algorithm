import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, N, S;

    static int[] arr;

    public static void main(String[] args) throws Exception {
        T = 1;

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());

        }
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sb.append(go());
        System.out.println(sb);
    }

    private static int go() {
        int start = 0, end = 0;

        int len = 0x7fffffff;
        int sum = 0;
        while (start <= end && end <= N) {
            if (sum < S) {
                sum += arr[end++];
            } else {
                len = Math.min(len, end - start);
                sum -= arr[start++];
            }
        }

        return len == 0x7fffffff ? 0 : len;
    }
}
