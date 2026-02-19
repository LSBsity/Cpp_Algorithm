import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, N, M;

    static int[] parent;

    public static void main(String[] args) throws Exception {
        T = 1;

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            parent = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                parent[i] = i;
            }

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 1; j <= N; j++) {
                    if (st.nextToken().equals("1")) union(i, j);
                }
            }

            st = new StringTokenizer(br.readLine());
            int first = find(Integer.parseInt(st.nextToken()));

            while (st.hasMoreTokens()) {
                if (find(Integer.parseInt(st.nextToken())) != first) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.print("YES");
    }


    private static int find(int x) {
        if (parent[x] == x) return x;

        return parent[x] = find(parent[x]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }
}
