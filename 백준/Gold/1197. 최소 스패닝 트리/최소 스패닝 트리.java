import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, V, E;

    static int[] parent;
    static List<int[]> edges;

    public static boolean union(int a, int b) {
        int aa = find(a);
        int bb = find(b);

        if (aa == bb) return true;

        if (aa < bb) {
            parent[bb] = aa;
        } else {
            parent[aa] = bb;
        }
        return false;
    }


    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public static void main(String[] args) throws Exception {
        T = 1;

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            edges = new ArrayList<>();
            parent = new int[V + 1];
            for (int i = 0; i <= V; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                edges.add(new int[]{u, v, w});
            }

            Collections.sort(edges, (o1, o2) -> Integer.compare(o1[2], o2[2]));

            sb.append(go());
        }

        System.out.println(sb);
    }

    private static long go() {
        long answer = 0;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (!union(u, v)) answer += w;
        }

        return answer;
    }
}
