import java.io.*;
import java.util.*;

// using prim algorithm
public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;

    static StringBuilder sb = new StringBuilder();

    static int T, N;

    static int[] dx;
    static int[] dy;

    static double tax;

    static List<Node>[] adjList;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            init();
            long result = go();

            sb.append('#')
                    .append(t)
                    .append(' ')
                    .append(Math.round(tax * result))
                    .append('\n');
        }

        System.out.println(sb);
    }

    public static long go() {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(1, 0));

        long sum = 0;
        int count = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (visited[current.vertex])
                continue;

            visited[current.vertex] = true;
            sum += current.weight;
            count++;

            if (count == N)
                break;

            for (Node next : adjList[current.vertex]) {
                if (!visited[next.vertex]) {
                    pq.offer(next);
                }
            }
        }

        return sum;
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        dx = new int[N];
        dy = new int[N];
        adjList = new List[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            adjList[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dx[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dy[i] = Integer.parseInt(st.nextToken());
        }

        tax = Double.parseDouble(br.readLine());

        buildEdges();
    }

    public static void buildEdges() {

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                long nx = dx[i] - dx[j];
                long ny = dy[i] - dy[j];

                long w = nx * nx + ny * ny;
                adjList[i].add(new Node(j, w));
                adjList[j].add(new Node(i, w));
            }
        }
    }

    static class Node implements Comparable<Node> {
        int vertex;
        long weight;

        public Node(int vertex, long weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.weight, o.weight);
        }
    }
}
