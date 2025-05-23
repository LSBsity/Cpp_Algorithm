import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine()); // 날짜 수
            int[] prices = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                prices[i] = Integer.parseInt(st.nextToken());
            }
            long result = go(prices, n);
            System.out.printf("#%d %d\n", t, result);
        }
    }

    private static long go(int[] prices, int size) {
        Deque<Long> stk = new ArrayDeque<>();
        long sum = 0;
        stk.push((long) (prices[prices.length - 1]));
        for (int i = prices.length - 2; i >= 0; i--) {
            if (!stk.isEmpty() && stk.peek() > prices[i]) {
                sum += stk.peek() - prices[i];
            } else if (!stk.isEmpty() && stk.peek() < prices[i]) {
                stk.pop();
                stk.push((long) prices[i]);
            }
        }
        return sum;
    }
}
