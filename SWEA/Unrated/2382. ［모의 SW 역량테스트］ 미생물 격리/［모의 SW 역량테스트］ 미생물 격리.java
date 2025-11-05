import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int T, N, M, K;
    static int sum;
    static List<int[]> micros;

    static int[][] map;
    static int[][] counts;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            micros = new ArrayList<>();
            map = new int[N][N];
            sum = 0;

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int micro = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());

                micros.add(new int[]{x, y, micro, dir - 1});
            }

            go();

            sb.append('#')
                    .append(t)
                    .append(' ')
                    .append(sum)
                    .append('\n');
        }

        System.out.println(sb);
    }

    private static void go() {
        for (int m = 0; m < M; m++) {
            counts = new int[N][N];

            for (int i = 0; i < micros.size(); i++) {
                int[] cur = micros.get(i);

                int dir = cur[3];
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if (nx == 0 || ny == 0 || nx == N - 1 || ny == N - 1) {
                    int newDir = getNewDir(dir);
                    cur[2] /= 2;
                    cur[3] = newDir;
                }
                cur[0] = nx;
                cur[1] = ny;
                micros.set(i, cur);
                
                counts[nx][ny]++;
            }

            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    if (counts[x][y] >= 2) {
                        int maxValue = 0x80000000;
                        int newDir = -1;
                        int sum = 0;
                        for (int i = micros.size() - 1; i >= 0; i--) {
                            int[] micro = micros.get(i);
                            if (micro[0] == x && micro[1] == y) {
                                if (maxValue < micro[2]) {
                                    maxValue = micro[2];
                                    newDir = micro[3];
                                }
                                sum += micro[2];
                                micros.remove(i);
                            }
                        }
                        micros.add(new int[]{x, y, sum, newDir});
                    }
                }
            }
        }


        for (int i = 0; i < micros.size(); i++) {
            sum += micros.get(i)[2];
        }
    }

    private static int getNewDir(int dir) {
        if (dir == 0) {
            return 1;
        } else if (dir == 1) {
            return 0;
        } else if (dir == 2) {
            return 3;
        }
        return 2;
    }
}