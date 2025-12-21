import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, N;

    static int[] arr;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws Exception {
        T = 1;

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            arr = new int[N];
            pq = new PriorityQueue<>();

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
                pq.add(arr[i]);
            }

            int result = go();
            sb.append(result);
        }

        System.out.print(sb);
    }

    private static int go() {
        int result = 0;
        while (!pq.isEmpty()) {
            if (pq.size() >= 2) {
                int p1 = pq.poll();
                int p2 = pq.poll();
                int sum = p1 + p2;
                result += sum;
                pq.add(sum);
            } else {
                return result;
            }
        }
        return result;
    }
}
