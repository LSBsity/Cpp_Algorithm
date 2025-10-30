import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;

    static int T;
    static int sum;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sum = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 10; i++) {
                int next = Integer.parseInt(st.nextToken());
                if ((next & 1) == 1) {
                    sum += next;
                }
            }
            sb.append('#')
                    .append(t)
                    .append(' ')
                    .append(sum)
                    .append('\n');
        }

        System.out.print(sb);
    }
}
