import java.io.*;
import java.util.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;

    static StringBuilder sb = new StringBuilder();

    static int T;
    static int V, E;

    static List<Node>[] adjList;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            visited = new boolean[V + 1];
            adjList = new ArrayList[V + 1];
            for (int i = 0; i < V + 1; i++) {
                adjList[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());

                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                adjList[from].add(new Node(to, weight));
                adjList[to].add(new Node(from, weight));
            }

            long result = go(1);

            sb.append('#')
                    .append(t)
                    .append(' ')
                    .append(result)
                    .append('\n');
        }

        System.out.println(sb);
    }

    public static long go(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));

        long sum = 0;
        int count = 0;
        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (visited[current.vertex])
                continue;

            visited[current.vertex] = true;
            sum += current.weight;
            count++;

            if (count == V)
                break;

            for (Node next : adjList[current.vertex]) {
                if (!visited[next.vertex]) {
                    pq.offer(next);
                }
            }
        }

        return sum;
    }

    static class Node implements Comparable<Node> {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}