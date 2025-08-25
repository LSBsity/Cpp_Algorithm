import java.io.*;
import java.util.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    static StringBuilder sb = new StringBuilder();

    static int T, N;
    static char[][] board;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
    static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            board = new char[N][N];
            map = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                board[i] = br.readLine().toCharArray();
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == '*') {
                        map[i][j] = -1; 
                    } else {
                        map[i][j] = count(i, j);
                    }
                }
            }

            int answer = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j] == 0) {
                        bfs(i, j);
                        answer++;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j] > 0) {
                        answer++;
                    }
                }
            }
            
            sb.append(String.format("#%d %d", t, answer))
                    .append('\n');
        }

        System.out.println(sb);
    }

    static int count(int x, int y) {
        int cnt = 0;
        for (int d = 0; d < 8; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N)
                continue;

            if (board[nx][ny] == '*')
                cnt++;
        }
        return cnt;
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { x, y });
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (map[cur[0]][cur[1]] == 0) {
                for (int d = 0; d < 8; d++) {
                    int nx = cur[0] + dx[d];
                    int ny = cur[1] + dy[d];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || map[nx][ny] == -1)
                        continue;

                    visited[nx][ny] = true;
                    q.offer(new int[] { nx, ny });
                }
            }
        }
    }
}
