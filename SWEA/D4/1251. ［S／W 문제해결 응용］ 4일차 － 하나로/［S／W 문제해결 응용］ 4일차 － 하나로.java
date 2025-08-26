import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;

    static StringBuilder sb = new StringBuilder();

    static int T;
    static int N;
    static double tax;

    static int[] dx, dy;

    static Edge[] edges;
    static int[] parents;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            dx = new int[N];
            dy = new int[N];

            edges = new Edge[N - 1];
            parents = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                dx[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                dy[i] = Integer.parseInt(st.nextToken());
            }

            tax = Double.parseDouble(br.readLine());

            edges = buildEdges();
            Arrays.sort(edges);
            make();

            long result = 0;
            int cnt = 0;
            for (Edge edge : edges) {
                if (!union(edge.from, edge.to)) continue;

                result += edge.weight;
                if (++cnt == N - 1) break; 
            }

            sb.append('#')
            .append(t)
            .append(' ')
            .append(Math.round(result * tax))
            .append('\n');
        }

        System.out.println(sb);
    }

    public static void make() {
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }
    }

    public static int find(int a) {
        if (a == parents[a])
            return a;
        return parents[a] = find(parents[a]);
    }

    public static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot)
            return false;

        parents[bRoot] = aRoot;

        return true;
    }

    public static Edge[] buildEdges() {
        int n = dx.length;
        List<Edge> list = new ArrayList<>(n * (n - 1) / 2);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long nx = dx[i] - (long) dx[j];
                long ny = dy[i] - (long) dy[j];

                long w = nx * nx + ny * ny;
                list.add(new Edge(i, j, w));
            }
        }

        return list.toArray(new Edge[0]);
    }

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        long weight;

        public Edge(int from, int to, long weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.weight, o.weight);
        }
    }
}
