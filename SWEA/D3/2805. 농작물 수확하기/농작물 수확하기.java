import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int size = Integer.parseInt(br.readLine());
            int start = size / 2, end = size / 2 + 1;
            int sum = 0;
            for (int i = 0; i < size; i++) {
                String line = String.valueOf(br.readLine()).substring(start, end);
                for (int j = 0; j < line.length(); j++) {
                    sum += line.charAt(j) - '0';
                }
                if (i < size / 2) {
                    start--;
                    end++;
                } else {
                    start++;
                    end--;
                }
            }
            System.out.printf("#%d %d\n", t + 1, sum);
        }
    }
}