import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;

    static StringBuilder sb = new StringBuilder();

    static int N;
    static String[] data; 
    static int[] left, right;

    public static void main(String[] args) throws Exception {

        for (int t = 1; t <= 10; t++) {
            N = Integer.parseInt(br.readLine());

            data = new String[N + 1];
            left = new int[N + 1];
            right = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                int index = Integer.parseInt(st.nextToken());
                data[index] = st.nextToken();
                if (st.hasMoreTokens()) left[index] = Integer.parseInt(st.nextToken());
                if (st.hasMoreTokens()) right[index] = Integer.parseInt(st.nextToken());
            }

            sb.append("#")
                    .append(t)
                    .append(" ");
            
            inorder(1);

            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static void inorder(int index) {
        if (index == 0) return;

        inorder(left[index]);
        sb.append(data[index]);
        inorder(right[index]);
    }
}