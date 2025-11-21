import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int T, N;

    static int[][] map;

    static int roomNum, maxVal;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];

            maxVal = 0x80000000;
            roomNum = 0x7fffffff;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    go(i, j);
                }
            }

            sb.append('#')
                    .append(t)
                    .append(' ')
                    .append(roomNum)
                    .append(' ')
                    .append(maxVal)
                    .append('\n');
        }

        System.out.println(sb);
    }

    private static void go(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{x, y, 1});

        int maxMove = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            maxMove = Math.max(maxMove, cur[2]);

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (map[nx][ny] != map[cur[0]][cur[1]] + 1) continue;

                q.offer(new int[]{nx, ny, cur[2] + 1});
            }
        }

        if (maxMove > maxVal) {
            maxVal = maxMove;
            roomNum = map[x][y];
        } else if (maxMove == maxVal) {
            roomNum = Math.min(roomNum, map[x][y]);
        }
    }
}
