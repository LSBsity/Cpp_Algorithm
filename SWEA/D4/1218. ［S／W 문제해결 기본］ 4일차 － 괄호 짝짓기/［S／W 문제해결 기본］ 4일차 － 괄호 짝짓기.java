import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T;
    static int length;

    static char[] chars;

    static Map<Character, Character> map = new HashMap<>();
    static {
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        map.put('<', '>');
    }


    public static void main(String[] args) throws Exception {
        T = 10;

        for (int t = 1; t <= T; t++) {
            length = Integer.parseInt(br.readLine());

            chars = br.readLine().toCharArray();

            sb.append('#')
                    .append(t)
                    .append(' ')
                    .append(go() ? 1 : 0)
                    .append('\n');
        }

        System.out.println(sb);
    }


    private static boolean go() {
        Deque<Character> stk = new ArrayDeque<>();

        for (char cur : chars) {
            if (isOpen(cur)) {
                stk.push(cur);
            } else {
                if (stk.isEmpty()) return false;

                char open = stk.pop();
                char close = map.get(open);

                if (cur != close) return false;
            }
        }

        return stk.isEmpty();
    }

    private static boolean isOpen(char c) {
        return c == '(' || c == '[' || c == '{' || c == '<';
    }
}