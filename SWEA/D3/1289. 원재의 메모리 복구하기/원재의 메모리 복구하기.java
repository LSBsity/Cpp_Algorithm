import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T;

    static int[] origin, reset;
    static int first, answer;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String str = br.readLine();
            origin = new int[str.length()];
            reset = new int[str.length()];

            for (int i = 0; i < str.length(); i++) {
                origin[i] = str.charAt(i) - '0';
            }

            first = str.indexOf("1");

            if (first == -1) {
                answer = 0;
            } else {
                answer = go();
            }

            sb.append('#')
                    .append(t)
                    .append(' ')
                    .append(answer)
                    .append('\n');
        }

        System.out.println(sb);
    }

    public static int go() {
        int cnt = 0;
        for (int i = first; i < origin.length; i++) {
            if (origin[i] == 1 && reset[i] == 0) {
                for (int j = i; j < origin.length; j++) {
                    reset[j] = 1;
                }
                cnt++;
            } else if (origin[i] == 0 && reset[i] == 1) {
                for (int j = i; j < origin.length; j++) {
                    reset[j] = 0;
                }
                cnt++;
            }
        }
        return cnt;
    }

}