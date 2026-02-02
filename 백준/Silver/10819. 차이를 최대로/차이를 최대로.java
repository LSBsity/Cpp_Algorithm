import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, N;
    static int[] arr, temp;
    static boolean[] visited;

    static int max;

    public static void main(String[] args) throws Exception {
        T = 1;

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            arr = new int[N];
            temp = new int[N];
            visited = new boolean[N];
            max = 0x80000000;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
        }

        go(0);
        sb.append(max);

        System.out.print(sb);
    }


    private static void go(int depth) {
        if (depth == N) {
            max = Math.max(max, sum());
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp[depth] = arr[i];
                go(depth + 1);
                visited[i] = false;
            }
        }
    }

    private static int sum() {
        int sum = 0;
        for (int i = 0; i < N - 1; i++) {
            sum += Math.abs(temp[i] - temp[i + 1]);
        }
        return sum;
    }
}
