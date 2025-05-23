import java.io.*;
import java.util.*;

public class Solution {

    static Map<String, Integer> map = new HashMap<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        map.put("0001101", 0);
        map.put("0011001", 1);
        map.put("0010011", 2);
        map.put("0111101", 3);
        map.put("0100011", 4);
        map.put("0110001", 5);
        map.put("0101111", 6);
        map.put("0111011", 7);
        map.put("0110111", 8);
        map.put("0001011", 9);

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            String[] arr = new String[N];
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                arr[i] = str;
            }
            System.out.printf("#%d %d\n", t + 1, go(arr));
        }
    }

    private static int go(String[] arr) {
        int[] code = new int[8];
        for (String line : arr) {
            int lastIdx = line.lastIndexOf("1");
            if (lastIdx == -1) continue;

            String block = line.substring(lastIdx - 55, lastIdx + 1);
            for (int i = 0, idx = 0; i < 56; i += 7) {
                String str = block.substring(i, i + 7);
                Integer value = map.get(str);
                if (value == null) {
                    return 0;
                }
                code[idx++] = value;
            }
        }
        int even = 0, odd = 0;
        for (int i = 0; i < code.length; i++) {
            if (i % 2 == 0) {
                even += code[i];
            } else {
                odd += code[i];
            }
        }
        if ((even * 3 + odd) % 10 == 0) {
            return even + odd;
        } else {
            return 0;
        }
    }
}