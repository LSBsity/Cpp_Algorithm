import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, N, M;
    static int[] parent, cities;

    public static void main(String[] args) throws Exception {
        T = 1;

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());

            parent = new int[N + 1];
            cities = new int[M];
            for (int i = 1; i <= N; i++) {
                parent[i] = i;
            }

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 1; j <= N; j++) {
                    int v = Integer.parseInt(st.nextToken());
                    if (v == 1) {
                        union(i, j);
                    }
                }
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                cities[i] = Integer.parseInt(st.nextToken());
            }

            boolean answer = true;
            for (int i = 0; i < M - 1; i++) {
                int aa = find(cities[i]);
                int bb = find(cities[i + 1]);
                if (aa != bb) {
                    answer = false;
                    break;
                }
            }
            sb.append(answer ? "YES" : "NO");
        }

        System.out.print(sb);
    }

    private static void union(int a, int b) {
        int aa = find(a);
        int bb = find(b);

        parent[bb] = aa;
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }
}
