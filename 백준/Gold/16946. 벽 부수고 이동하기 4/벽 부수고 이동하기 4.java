import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;

    static int[][] map;
    static int[][] result;            // [변경] 결과 전용 배열
    static boolean[][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        result = new int[N][M];        // [변경] 결과 배열 초기화

        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = chars[j] - '0';
                result[i][j] = map[i][j]; // [변경] 벽이면 1, 빈칸이면 0 유지
            }
        }

        go();
        System.out.print(sb);
    }

    private static void go() {
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(result[i][j] % 10); // [변경] result 출력
            }
            sb.append('\n');
        }
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        List<int[]> zeros = new ArrayList<>();   // [유지] 0 컴포넌트 저장
        Set<Integer> walls = new HashSet<>();    // [유지] 인접 벽 중복 제거

        q.offer(new int[]{x, y});
        visited[x][y] = true;
        zeros.add(new int[]{x, y});

        int cnt = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if (map[nx][ny] == 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                    zeros.add(new int[]{nx, ny});
                    cnt++;
                } else if (map[nx][ny] == 1) {
                    walls.add(nx * M + ny); // 좌표 압축
                }
            }
        }

        // [변경] 벽에 결과를 누적 (입력 map이 아니라 result에!)
        for (int key : walls) {
            int wx = key / M;
            int wy = key % M;
            result[wx][wy] += cnt;
        }
    }
}
