import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String str = br.readLine();
            sb.append('#')
                    .append(t)
                    .append(' ')
                    .append(go(str))
                    .append('\n');
        }

        System.out.println(sb);
    }

    private static int go(String str) {
        for (int i = 1; i < str.length(); i++) {
            String subStr = str.substring(0, i);

            boolean check = true;
            for (int j = 0; j < str.length() - subStr.length(); j += subStr.length()) {
                if (!str.substring(j, j + subStr.length()).equals(subStr)) {
                    check = false;
                    break;
                }
            }
            if (check) return i;
        }
        return -1;
    }

}
