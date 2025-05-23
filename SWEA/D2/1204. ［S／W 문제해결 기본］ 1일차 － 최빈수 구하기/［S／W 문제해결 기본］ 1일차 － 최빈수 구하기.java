import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] scores = new int[1000];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 1000; i++) {
                scores[i] = Integer.parseInt(st.nextToken());
            }
            System.out.printf("#%d %d\n", N, go(scores));
        }
    }

    private static int go(int[] scores) {
        int[] v = new int[1000];
        for (int i = 0; i < 1000; i++) {
            v[scores[i]]++;
        }

        int max = -1;
        int idx = -1;
        for (int i = 0; i < 1000; i++) {
            if (v[i] >= max) {
                max = v[i];
                idx = i;
            }
        }
        return idx;
    }
}
