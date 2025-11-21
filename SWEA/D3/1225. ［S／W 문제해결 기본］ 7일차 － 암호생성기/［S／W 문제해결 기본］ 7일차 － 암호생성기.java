import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Solution {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T;

    public static void main(String[] args) throws Exception {
        T = 10;

        for (int t = 1; t <= T; t++) {
            int num = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            Deque<Integer> dq = new ArrayDeque<>();

            for (int i = 0; i < 8; i++) {
                dq.offerLast(Integer.valueOf(st.nextToken()));
            }

            int idx = 1;
            while (true) {
                Integer pollFirst = dq.pollFirst();
                int val = pollFirst - idx;
                if (val <= 0) {
                    dq.offerLast(0);
                    break;
                }
                dq.offerLast(val);

                idx = (idx % 5) + 1;
            }

            String result = dq.stream().map(String::valueOf)
                    .collect(Collectors.joining(" "));

            sb.append('#')
                    .append(num)
                    .append(' ')
                    .append(result)
                    .append('\n');
        }

        System.out.println(sb);
    }

}
