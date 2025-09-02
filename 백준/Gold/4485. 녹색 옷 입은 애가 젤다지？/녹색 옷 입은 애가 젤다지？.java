import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;

    static StringBuilder sb = new StringBuilder();

    static int T, N;
    static int result;

    static int[][] map;
    static int[][] minTime;
    static boolean[][] visited;

    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        int t = 0;
        while (true) {
            t++;
            N = Integer.parseInt(br.readLine());

            if (N == 0)
                break;

            map = new int[N][N];
            minTime = new int[N][N];
            visited = new boolean[N][N];
            result = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    minTime[i][j] = INF;
                }
            }

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            result = go(0, 0);

            sb.append("Problem")
                    .append(' ')
                    .append(t)
                    .append(':')
                    .append(' ')
                    .append(result + map[0][0])
                    .append('\n');
        }

        System.out.println(sb);
    }

    public static int go(int x, int y) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));

        minTime[x][y] = 0;
        pq.offer(new int[] { x, y, minTime[x][y] });

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            if (visited[current[0]][current[1]])
                continue;
            visited[current[0]][current[1]] = true;

            if (current[0] == N - 1 && current[1] == N - 1) {
                return current[2];
            }

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N)
                    continue;
                if (visited[nx][ny])
                    continue;
                if (minTime[nx][ny] <= current[2] + map[nx][ny])
                    continue;

                minTime[nx][ny] = current[2] + map[nx][ny];
                pq.offer(new int[] { nx, ny, current[2] + map[nx][ny] });
            }
        }

        return -1;
    }
}
