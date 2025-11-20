import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            char[] chars = br.readLine().toCharArray();
            Deque<Character> q = new ArrayDeque<>();
            Deque<Character> stk = new ArrayDeque<>();

            for (char c : chars) {
                q.offer(c);
                stk.push(c);
            }

            boolean check = true;
            for (int i = 0; i < chars.length / 2; i++) {
                if (q.poll() != stk.pop()) {
                    check = false;
                    break;
                }
            }
            
            sb.append('#')
                    .append(t)
                    .append(' ')
                    .append(check ? '1' : '0')
                    .append('\n');
        }

        System.out.println(sb);
    }

}
