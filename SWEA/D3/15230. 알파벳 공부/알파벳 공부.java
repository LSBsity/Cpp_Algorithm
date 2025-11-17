import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    static final String str = "abcdefghijklmnopqrstuvwxyz";
    static int T;


    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String line = br.readLine();

            int cnt = 0;
            for (int i = 1; i <= line.length(); i++) {
                if (str.startsWith(line.substring(0, i))) {
                    cnt++;
                } else {
                    break;
                }
            }
            sb.append('#')
                    .append(t)
                    .append(' ')
                    .append(cnt)
                    .append('\n');
        }

        System.out.println(sb);
    }

}
