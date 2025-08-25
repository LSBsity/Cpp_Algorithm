import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;

    static StringBuilder sb = new StringBuilder();

    static int T;
    static int n, m;

    static int[] parent;

    static void union(int n1, int n2) {
        int a = find(n1);
        int b = find(n2);

        if (a > b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    static int find(int n) {
        if (parent[n] != n) {
            parent[n] = find(parent[n]);
        }
        return parent[n];
    }

    static boolean connected(int n1, int n2) {
        return find(n1) == find(n2);
    }

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        
        for (int t = 1; t <= T; t++) {
            String[] line = br.readLine().split(" ");
            
            n = Integer.parseInt(line[0]);
            m = Integer.parseInt(line[1]);

            parent = new int[n + 1];

            for (int i = 0; i <= n; i++) {
                parent[i] = i;
            }

            sb.append(String.format("#%d ", t));
            for (int i = 0; i < m; i++) {
                line = br.readLine().split(" ");

                int cmd = Integer.parseInt(line[0]);
                int a = Integer.parseInt(line[1]);
                int b = Integer.parseInt(line[2]);

                if (cmd == 0) {
                    union(a, b);
                } else if (cmd == 1) {
                    sb.append(connected(a, b) ? 1 : 0);
                }

            }

            sb.append('\n');
        }

        System.out.println(sb);
    }

}
