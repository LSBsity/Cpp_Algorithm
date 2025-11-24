import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T;

    static int[] cnt;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String str = br.readLine();

            cnt = new int[10];

            for (int i = 0; i < str.length(); i++) {
                int num = str.charAt(i) - '0';
                cnt[num]++;
            }

            boolean isExist = false;
            boolean isMatch = true;
            for (int i = 0; i < 10; i++) {
                if (cnt[i] == 2) {
                    isExist = true;
                    int first = str.indexOf(String.valueOf(i));
                    int last = str.indexOf(String.valueOf(i), first + 1);

                    int should = last - first - 1;
                    isMatch = should == i;
                    if (!isMatch) {
                        break;
                    }
                } else if (cnt[i] != 0) {
                    isExist = false;
                    break;
                }
            }

            if (!isExist) {
                sb.append("no");
            } else {
                if (isMatch) {
                    sb.append("yes");
                } else {
                    sb.append("no");
                }
            }
            sb.append('\n');

        }

        System.out.println(sb);
    }

}
