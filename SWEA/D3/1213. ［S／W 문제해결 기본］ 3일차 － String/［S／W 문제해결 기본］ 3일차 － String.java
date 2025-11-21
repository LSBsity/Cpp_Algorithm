import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T;
    static int cnt;

    static String pat, str;

    public static void main(String[] args) throws Exception {
        T = 10;

        for (int t = 1; t <= T; t++) {
            int num = Integer.parseInt(br.readLine());

            pat = br.readLine();
            str = br.readLine();
            cnt = 0;

            int strLen = str.length();
            int patLen = pat.length();

            for (int i = 0; i < strLen - patLen + 1; i++) {
                if (str.startsWith(pat, i)) cnt++;
            }

            sb.append('#')
                    .append(num)
                    .append(' ')
                    .append(cnt)
                    .append('\n');
        }

        System.out.println(sb);
    }

}
