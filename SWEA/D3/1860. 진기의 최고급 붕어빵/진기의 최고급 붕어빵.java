import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, N;
    static int M, K;

    static int[] customers;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            customers = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                customers[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(customers);

            sb.append('#')
                    .append(t)
                    .append(' ')
                    .append(go())
                    .append('\n');
        }

        System.out.println(sb);
    }

    private static String go() {
        if (customers[0] < M) {
            return "Impossible";
        }

        int size = customers[customers.length - 1];

        Queue<Integer> customerQ = new ArrayDeque<>();
        for (int i = 0; i < customers.length; i++) {
            customerQ.offer(customers[i]);
        }

        int breads = 0;
        for (int i = 1; i <= size; i++) {
            if (i % M == 0) {
                breads += K;
            }

            if (customerQ.peek() == i) { // 손놈이 올 시간이면
                if (breads == 0) return "Impossible";

                while (customerQ.peek() <= i) {
                    customerQ.poll();
                    breads--;
                    if (customerQ.isEmpty()) {
                        return "Possible";
                    }
                }
            } else if (customerQ.peek() < i) {
                return "Impossible";
            }
        }

        return "Possible";
    }
}
