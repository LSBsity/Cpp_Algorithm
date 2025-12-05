import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int answer1, answer2;

    static int T, N;

    static int[][] map, map2;
    static boolean[][] visited, visited2;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        T = 1;

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            map2 = new int[N][N];
            visited = new boolean[N][N];
            visited2 = new boolean[N][N];

            answer1 = answer2 = 0;

            for (int i = 0; i < N; i++) {
                char[] chars = br.readLine().toCharArray();
                for (int j = 0; j < N; j++) {
                    char c = chars[j];
                    if (c == 'R') {
                        map[i][j] = 1;
                    } else if (c == 'G') {
                        map[i][j] = 2;
                    } else if (c == 'B') {
                        map[i][j] = 3;
                    }

                    if (c == 'R' || c == 'G') {
                        map2[i][j] = 1;
                    } else {
                        map2[i][j] = 2;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        go(map, visited, i, j);
                        answer1++;
                    }
                    if (!visited2[i][j]) {
                        go(map2, visited2, i, j);
                        answer2++;
                    }
                }
            }

            sb.append(answer1)
                    .append(' ')
                    .append(answer2)
                    .append('\n');
        }

        System.out.println(sb);
    }

    private static void go(int[][] map, boolean[][] visited, int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] != map[cur[0]][cur[1]]) continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
    }
}