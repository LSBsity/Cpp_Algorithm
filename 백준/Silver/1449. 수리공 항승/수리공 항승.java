import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, N, L;
    static int[] arr;
    static int cnt;

    public static void main(String[] args) throws Exception {
        T = 1;

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            arr = new int[N];
            cnt = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            go();
            sb.append(cnt);
        }


        System.out.print(sb);
    }

    private static void go() {
        double right = -1;
        for (int i = 0; i < N; i++) {
            double left = arr[i] + 0.5;
            if (right < left) {
                cnt++;
                right = left - 0.5 + L;
            }
        }
    }
}
