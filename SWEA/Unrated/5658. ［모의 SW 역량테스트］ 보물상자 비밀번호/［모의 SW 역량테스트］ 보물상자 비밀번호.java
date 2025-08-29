import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;

    static StringBuilder sb = new StringBuilder();
    static int T, N, K;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            char[] chars = br.readLine().toCharArray();
            Set<Integer> set = new HashSet<>();
            int spinCount = chars.length / 4;

            for (int i = 0; i < spinCount; i++) {
                String temp = "";
                for (int j = i; j < N + i; j++) {
                    temp += chars[j % chars.length];
                    if (temp.length() == spinCount) {
                        set.add(Integer.parseInt(temp, 16));
                        temp = "";
                    }
                }
            }

            int result = set.stream()
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList())
                    .get(K - 1);

            sb.append('#')
                    .append(t)
                    .append(' ')
                    .append(result)
                    .append('\n');
        }

        System.out.println(sb);
    }
}