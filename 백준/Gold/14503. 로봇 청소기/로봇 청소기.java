import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int T, N, M;
    static int answer;
    
    static int[] init = {0, 0, 0};
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    static int[][] map;

    public static void main(String[] args) throws Exception {
        T = 1;

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            answer = 0;

            st = new StringTokenizer(br.readLine());
            init[0] = Integer.parseInt(st.nextToken());
            init[1] = Integer.parseInt(st.nextToken());
            init[2] = Integer.parseInt(st.nextToken());

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            go();

            sb.append(answer);
        }
        System.out.print(sb);
    }

    private static void go() {
        int[] cur = {init[0], init[1], init[2]};

        while (true) {
            int x = cur[0];
            int y = cur[1];
            int dir = cur[2];

            if (map[x][y] == 0) {
                map[x][y] = 2;
                answer++;
            }

            boolean moved = false;
            for (int i = 0; i < 4; i++) {
                dir = getLeftDir(dir);
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (map[nx][ny] == 0) {
                    cur = new int[]{nx, ny, dir};
                    moved = true;
                    break;
                }
            }

            if (!moved) {
                int backDir = getBackDir(dir);
                int nx = x + dx[backDir];
                int ny = y + dy[backDir];

                if (map[nx][ny] == 1) {
                    return;
                }
                cur = new int[]{nx, ny, dir};
            }
        }
    }

    private static int getLeftDir(int currentDir) {
        switch (currentDir) {
            case 0:
                return 3;
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            default:
                return -1;
        }
    }

    private static int getBackDir(int currentDir) {
        switch (currentDir) {
            case 0:
                return 2;
            case 1:
                return 3;
            case 2:
                return 0;
            case 3:
                return 1;
            default:
                return -1;
        }
    }
}