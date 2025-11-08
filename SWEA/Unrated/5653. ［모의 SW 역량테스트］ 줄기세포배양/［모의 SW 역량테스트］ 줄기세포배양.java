import java.io.*;
import java.util.*;

public class Solution {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T;
    static int R, C, K;

    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static Queue<Cell> q;

    public static void main(String[] args) throws NumberFormatException, IOException {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[R + K + 1][C + K + 1];
            visited = new boolean[R + K + 1][C + K + 1];
            q = new ArrayDeque();

            for (int i = K / 2 + 1; i < R + K / 2 + 1; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = K / 2 + 1; j < C + K / 2 + 1; j++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    if (tmp != 0) {
                        map[i][j] = tmp;
                        visited[i][j] = true;
                        q.offer(new Cell(i, j, tmp));
                    }
                }
            }
            go();
            sb.append('#')
                    .append(t)
                    .append(' ')
                    .append(q.size())
                    .append('\n');
        }

        System.out.println(sb);
    }

    private static void go() {
        while (K-- > 0) {

            for (Cell cell : q) {
                if (cell.status == 1) {
                    for (int d = 0; d < 4; d++) {
                        int nx = cell.x + dx[d];
                        int ny = cell.y + dy[d];

                        if (visited[nx][ny])
                            continue;

                        if (map[nx][ny] < cell.life)
                            map[nx][ny] = cell.life;
                    }
                }

            }

            int size = q.size();
            for (int s = 0; s < size; s++) {
                Cell cur = q.poll();

                if (cur.status == 1) {
                    for (int i = 0; i < 4; i++) {
                        int nx = cur.x + dx[i];
                        int ny = cur.y + dy[i];

                        if (visited[nx][ny]) continue;

                        visited[nx][ny] = true;
                        q.offer(new Cell(nx, ny, map[nx][ny]));
                    }
                }

                cur.run();

                if (cur.status != 2) {
                    q.offer(cur);
                }
            }
        }
    }

    static class Cell {
        int x;
        int y;
        int life;
        int time;
        int status; // 0. 비활성 / 1. 활성 / 2. 죽음

        public Cell(int x, int y, int life) {
            this.x = x;
            this.y = y;
            this.life = life;
            this.time = life;
        }

        void run() {
            switch (status) {
                case 0:
                    if (--time == 0)
                        this.status = 1;
                    break;
                case 1: // 활성화 상태
                    if (++time == life)
                        this.status = 2;
                    break;
            }

        }
    }

}