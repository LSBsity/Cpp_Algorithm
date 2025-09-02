import java.io.*;
import java.util.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;

    static StringBuilder sb = new StringBuilder();

    static int result;

    static int T;
    static int N, M, R, C, L;

    static int[][][] dirMap = {
            { // 1 상하좌우
                    { -1, 0, 1, 0 },
                    { 0, 1, 0, -1 }
            },
            { // 2 상하
                    { -1, 1 },
                    { 0, 0 }
            },
            { // 3 좌우
                    { 0, 0 },
                    { -1, 1 }
            },
            { // 4 상 우
                    { -1, 0 },
                    { 0, 1 }
            },
            { // 5 하 우
                    { 1, 0 },
                    { 0, 1 }
            },
            { // 6 하 좌
                    { 1, 0 },
                    { 0, -1, }
            },
            { // 7 상 좌
                    { -1, 0 },
                    { 0, -1 }
            },
    };

    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];
            result = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            go(R, C);
            sb.append('#')
                    .append(t)
                    .append(' ')
                    .append(result)
                    .append('\n');
        }

        System.out.println(sb);
    }

    public static void go(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[] { x, y, 1 });
        visited[x][y] = true;
        result++;

        while (!q.isEmpty()) {
            int[] current = q.poll();

            if (current[2] == L) {
                break;
            }

            int[][] dir = dirMap[map[current[0]][current[1]] - 1];
            int[] dx = dir[0];
            int[] dy = dir[1];

            for (int i = 0; i < dx.length; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;
                if (visited[nx][ny] || map[nx][ny] == 0)
                    continue;

                // 다음 위치의 통로 방향 배열
                int[][] nextDir = dirMap[map[nx][ny] - 1];
                int[] nextDx = nextDir[0];
                int[] nextDy = nextDir[1];

                // 현재 이동 방향의 반대 방향이 다음 칸에 존재하는지 확인
                int cx = dx[i] * -1;
                int cy = dy[i] * -1;
                boolean isMatched = false;
                for (int j = 0; j < nextDx.length; j++) {
                    if (nextDx[j] == cx && nextDy[j] == cy) {
                        isMatched = true;
                        break;
                    }
                }

                if (isMatched) {
                    q.offer(new int[] { nx, ny, current[2] + 1 });
                    visited[nx][ny] = true;
                    result++;
                }
            }
        }
    }
}