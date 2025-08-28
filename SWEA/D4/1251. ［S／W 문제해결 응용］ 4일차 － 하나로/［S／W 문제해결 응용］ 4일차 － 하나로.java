import java.io.*;
import java.util.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;

    static StringBuilder sb = new StringBuilder();

    static int T, N;
    static double tax;

    static int[][] island;
    static Edge[] edges;

    static boolean[] visited;
    static int[] parents;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            island = new int[2][N];
            visited = new boolean[N];

            parents = new int[N];
            for (int i = 0; i < N; i++) {
                parents[i] = i;
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                island[0][i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                island[1][i] = Integer.parseInt(st.nextToken());
            }

            tax = Double.parseDouble(br.readLine());

            edges = buildEdges();
            Arrays.sort(edges);

            long result = go();

            sb.append('#')
                    .append(t)
                    .append(' ')
                    .append(Math.round(tax * result))
                    .append('\n');
        }

        System.out.println(sb);
    }

    public static Edge[] buildEdges() {
        Edge[] newNodes = new Edge[(N * (N - 1)) / 2];

        for (int i = 0, idx = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                long nx = island[0][i] - island[0][j];
                long ny = island[1][i] - island[1][j];

                long w = nx * nx + ny * ny;
                newNodes[idx++] = new Edge(i, j, w);
            }
        }

        return newNodes;
    }

    public static int find(int a) {
        if (parents[a] == a)
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

    public static long go() {
        // todo kruskal
        long sum = 0;
        int count = 0;

        for (Edge edge : edges) {
            if (!union(edge.from, edge.to))
                continue;
            sum += edge.weight;
            count++;

            if (count == N - 1)
                break;
        }

        return sum;
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
