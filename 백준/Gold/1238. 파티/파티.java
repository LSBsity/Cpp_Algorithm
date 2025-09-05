import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;

    static StringBuilder sb = new StringBuilder();

    static int N, M, X;
    static int result;

    static List<Node>[] forward, reverse;

    static boolean[] check;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        forward = new List[N + 1];
        reverse = new List[N + 1];
        check = new boolean[N + 1];
        result = 9;

        for (int i = 1; i <= N; i++) {
            forward[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            forward[from].add(new Node(to, weight));
            reverse[to].add(new Node(from, weight));
        }

        int[] a = go(X, forward);
        int[] b = go(X, reverse);

        for (int i = 1; i <= N; i++) {
            result = Math.max(result, a[i] + b[i]);
        }

        System.out.println(result);
    }

    public static int[] go(int start, List<Node>[] graph) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
        pq.offer(new Node(start, 0));

        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (!visited[current.to]) {
                visited[current.to] = true;

                for (Node next : graph[current.to]) {
                    if (!visited[next.to] && dist[next.to] > dist[current.to] + next.weight) {
                        dist[next.to] = dist[current.to] + next.weight;
                        pq.offer(new Node(next.to, dist[next.to]));
                    }
                }
            }
        }

        return dist;
    }

    static class Node {

        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
