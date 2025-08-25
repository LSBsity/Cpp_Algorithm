import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;

    static StringBuilder sb = new StringBuilder();

    static int T;
    static int N, M;

    static int[] parent;

    public static void union(int n1, int n2) {
        int a = find(n1);
        int b = find(n2);

        if (a != b) { // 다른 집합일 때만 합침
            parent[b] = a; // 혹은 parent[a] = b; (둘 중 일관되게)
        }
    }

    public static int find(int n) {
        if (parent[n] != n) {
            parent[n] = find(parent[n]);
        }
        return parent[n];
    }

    public static boolean isConnected(int n1, int n2) {
        return find(n1) == find(n2);
    }

    public static void main(String[] args) throws Exception {

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String[] line = br.readLine().split(" ");
            N = Integer.parseInt(line[0]);
            M = Integer.parseInt(line[1]);

            parent = new int[N + 1];

            for (int i = 0; i <= N; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < M; i++) {
                line = br.readLine().split(" ");

                int a = Integer.parseInt(line[0]);
                int b = Integer.parseInt(line[1]);

                union(a, b);
            }

            for (int i = 1; i <= N; i++) {
                find(i);
            }

            Set<Integer> set = new HashSet<>();

            for (int i = 1; i <= N; i++) {
                set.add(parent[i]);
            }

            sb.append(String.format("#%d %d", t, set.size()))
                    .append('\n');
        }

        System.out.println(sb);
    }
}