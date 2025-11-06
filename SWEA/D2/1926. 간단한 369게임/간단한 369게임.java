import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;

    static boolean[] check = {false, false, false, true, false, false, true, false, false, true};

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            String num = String.valueOf(i);

            int cnt = 0;
            for (int j = 0; j < num.length(); j++) {
                if (check[num.charAt(j) - '0']) {
                    cnt++;
                }
            }

            if (cnt == 0) {
                sb.append(num).append(' ');
            } else {
                for (int j = 0; j < cnt; j++) {
                    sb.append('-');
                }
                sb.append(' ');
            }
        }


        System.out.println(sb);
    }
}