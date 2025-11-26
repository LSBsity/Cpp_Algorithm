import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, N;

    static Deque<Character> stk;

    public static void main(String[] args) throws Exception {
        T = 10;

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            char[] chars = st.nextToken().toCharArray();

            stk = new ArrayDeque<>();
            for (char c : chars) {
                if (stk.isEmpty()) {
                    stk.push(c);
                } else {
                    if (stk.peek() == c) {
                        stk.pop();
                    } else {
                        stk.push(c);
                    }
                }
            }

            sb.append('#')
                    .append(t)
                    .append(' ');
            while (!stk.isEmpty()) {
                sb.append(stk.pollLast());
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

}