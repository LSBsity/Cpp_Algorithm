import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static char[][] map;
    static int[][] coords = new int[2][2];

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Node {
        int x, y, dir, cnt;
        Node(int x, int y, int dir, int cnt) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        int idx = 0;
        for (int i = 0; i < N; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = row[j];
                if (map[i][j] == '#') {
                    coords[idx][0] = i;
                    coords[idx][1] = j;
                    idx++;
                }
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        int[][][] dist = new int[N][N][4];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);

        Deque<Node> dq = new ArrayDeque<>();

        int sx = coords[0][0];
        int sy = coords[0][1];
        int ex = coords[1][0];
        int ey = coords[1][1];

        for (int d = 0; d < 4; d++) {
            dist[sx][sy][d] = 0;
            dq.offer(new Node(sx, sy, d, 0));
        }

        while (!dq.isEmpty()) {
            Node cur = dq.poll();
            int x = cur.x;
            int y = cur.y;
            int dir = cur.dir;
            int cnt = cur.cnt;

            if (cnt > dist[x][y][dir]) continue;

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (map[nx][ny] == '*') continue;

            if (dist[nx][ny][dir] > cnt) {
                dist[nx][ny][dir] = cnt;
                dq.offerFirst(new Node(nx, ny, dir, cnt));
            }

            if (map[nx][ny] == '!') {
                for (int nd = 0; nd < 4; nd++) {
                    if (nd == dir) continue;
                    if ((dir + 2) % 4 == nd) continue;

                    if (dist[nx][ny][nd] > cnt + 1) {
                        dist[nx][ny][nd] = cnt + 1;
                        dq.offerLast(new Node(nx, ny, nd, cnt + 1));
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int d = 0; d < 4; d++) {
            ans = Math.min(ans, dist[ex][ey][d]);
        }
        return ans;
    }
}
