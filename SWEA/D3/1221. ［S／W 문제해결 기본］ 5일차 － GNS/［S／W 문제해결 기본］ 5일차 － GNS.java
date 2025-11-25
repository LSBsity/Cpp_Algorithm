import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T;

    static int len;

    static int[] cnt;

    static Map<String, Integer> strToInt = new HashMap<>();
    static Map<Integer, String> intToStr = new HashMap<>();

    static {
        strToInt.put("ZRO", 0);
        strToInt.put("ONE", 1);
        strToInt.put("TWO", 2);
        strToInt.put("THR", 3);
        strToInt.put("FOR", 4);
        strToInt.put("FIV", 5);
        strToInt.put("SIX", 6);
        strToInt.put("SVN", 7);
        strToInt.put("EGT", 8);
        strToInt.put("NIN", 9);

        intToStr.put(0, "ZRO");
        intToStr.put(1, "ONE");
        intToStr.put(2, "TWO");
        intToStr.put(3, "THR");
        intToStr.put(4, "FOR");
        intToStr.put(5, "FIV");
        intToStr.put(6, "SIX");
        intToStr.put(7, "SVN");
        intToStr.put(8, "EGT");
        intToStr.put(9, "NIN");
    }

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            sb.append(st.nextToken())
                    .append('\n');
            len = Integer.parseInt(st.nextToken());

            cnt = new int[10];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < len; i++) {
                int num = strToInt.get(st.nextToken());
                cnt[num]++;
            }

            for (int i = 0; i < 10; i++) {
                int size = cnt[i];
                String converted = intToStr.get(i);
                for (int j = 0; j < size - 1; j++) {
                    sb.append(converted)
                            .append(' ');
                }
                sb.append(converted)
                        .append(i == 9 ? '\n' : ' ');
            }
        }

        System.out.println(sb);
    }

}
