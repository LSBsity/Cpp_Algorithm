import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, X, N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        
        while (true) {
            String line = br.readLine();
            if (line == null) break;

            X = Integer.parseInt(line) * 10_000_000;
            N = Integer.parseInt(br.readLine());

            arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(arr);
            go();
        }

        System.out.print(sb);
    }

    private static void go() {
        int start = 0;
        int end = N - 1;

        while (start < end) {
            int a = arr[start];
            int b = arr[end];

            if (a + b == X) {
                sb.append("yes ")
                        .append(a)
                        .append(' ')
                        .append(b)
                        .append('\n');
                return;
            }

            if (a + b < X) {
                start++;
            } else {
                end--;
            }
        }

        sb.append("danger")
                .append('\n');
    }
}
