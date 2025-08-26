import java.io.*;
import java.util.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;

    static StringBuilder sb = new StringBuilder();

    static int T;
    static int V, E;

    static Edge[] edges;
    static int[] parents;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            String[] line = br.readLine().split(" ");
            V = Integer.parseInt(line[0]);
            E = Integer.parseInt(line[1]);

            edges = new Edge[E];
            parents = new int[V + 1];

            for (int i = 0; i < E; i++) {
                line = br.readLine().split(" ");
                edges[i] = new Edge(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2]));
            }

            make();
            Arrays.sort(edges);

            long sum = 0;
            int cnt = 0;
            for (Edge edge : edges) {
                if (!union(edge.from, edge.to))
                    continue;

                sum += edge.weight;
                if (++cnt == V - 1)
                    break;
            }

            sb.append('#')
                    .append(t)
                    .append(' ')
                    .append(sum)
                    .append('\n');
        }

        System.out.println(sb);
    }

    public static void make() {
        for (int i = 0; i < V; i++) {
            parents[i] = i;
        }
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

    static class Edge implements Comparable<Edge> {

        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}
