import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, H, W;

    static char[][] map;
    static boolean[][] fireVisited;
    static boolean[][] manVisited;


    static Queue<int[]> fireQ;
    static Queue<int[]> manQ;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int answer;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            map = new char[H][W];
            fireVisited = new boolean[H][W];
            manVisited = new boolean[H][W];
            answer = -1;

            fireQ = new ArrayDeque<>();
            manQ = new ArrayDeque<>();

            for (int i = 0; i < H; i++) {
                char[] chars = br.readLine().toCharArray();
                for (int j = 0; j < W; j++) {
                    map[i][j] = chars[j];
                    if (map[i][j] == '@') {
                        manVisited[i][j] = true;
                        manQ.offer(new int[]{i, j, 1});
                    }
                    if (map[i][j] == '*') {
                        fireVisited[i][j] = true;
                        fireQ.offer(new int[]{i, j, 1});
                    }
                }
            }

            go();

            sb.append(answer == -1 ? "IMPOSSIBLE" : answer)
                    .append('\n');
        }
        System.out.println(sb);
    }

    private static void go() {

        while (!manQ.isEmpty()) {

            int fireSize = fireQ.size();
            for (int i = 0; i < fireSize; i++) {
                int[] fireCur = fireQ.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = fireCur[0] + dx[j];
                    int ny = fireCur[1] + dy[j];

                    if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                    if (map[nx][ny] == '#' || fireVisited[nx][ny]) continue;

                    fireVisited[nx][ny] = true;
                    fireQ.offer(new int[]{nx, ny, fireCur[2] + 1});
                }
            }

            int manSize = manQ.size();
            for (int i = 0; i < manSize; i++) {
                int[] manCur = manQ.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = manCur[0] + dx[j];
                    int ny = manCur[1] + dy[j];

                    if (nx < 0 || ny < 0 || nx >= H || ny >= W) {
                        answer = manCur[2];
                        return;
                    }

                    if (map[nx][ny] == '#' || manVisited[nx][ny] || fireVisited[nx][ny]) continue;

                    manVisited[nx][ny] = true;
                    manQ.offer(new int[]{nx, ny, manCur[2] + 1});
                }
            }

        }
    }
}
