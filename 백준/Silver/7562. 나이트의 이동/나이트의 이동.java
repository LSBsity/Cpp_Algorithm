import java.util.*;
import java.io.*;

public class Main {

    static StringTokenizer st = null;
    static StringBuilder sb = new StringBuilder();

    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

    static int T;
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] now = {0, 0}, goal = {0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new boolean[N][N];

            st = new StringTokenizer(br.readLine());
            now[0] = Integer.parseInt(st.nextToken());
            now[1] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            goal[0] = Integer.parseInt(st.nextToken());
            goal[1] = Integer.parseInt(st.nextToken());

            go();
        }
    }

    private static void go() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{now[0], now[1], 0});
        visited[now[0]][now[1]] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];

            if (x == goal[0] && y == goal[1]) {
                System.out.println(current[2]);
                return;
            }

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;
                q.offer(new int[]{nx, ny, current[2] + 1});
                visited[nx][ny] = true;
            }
        }
    }
}
