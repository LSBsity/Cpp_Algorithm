import java.io.*;
import java.util.*;

class Main {
    static int r;
    static int c;

    static int[][] swan = new int[2][2];

    static char[][] map;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static Queue<int[]> swanQ = new LinkedList<>();
    static Queue<int[]> meltQ = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        boolean[][] visited = new boolean[r][c];

        int swanIdx = 0;
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'L') {
                    swan[swanIdx][0] = i;
                    swan[swanIdx++][1] = j;
                }
                if (map[i][j] != 'X') {
                    meltQ.offer(new int[]{i, j});
                }
            }
        }

        swanQ.offer(new int[]{swan[0][0], swan[0][1]});
        visited[swan[0][0]][swan[0][1]] = true;

        int count = 0;
        while (!canMeet(visited)) {
            melt();
            count++;
        }
        System.out.println(count);
        br.close();
    }

    private static boolean canMeet(boolean[][] visited) {
        Queue<int[]> nextQ = new LinkedList<>();

        while (!swanQ.isEmpty()) {
            int x = swanQ.peek()[0];
            int y = swanQ.peek()[1];
            swanQ.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                if (nx == swan[1][0] && ny == swan[1][1]) {
                    return true;
                } else if (map[nx][ny] == 'X') {
                    nextQ.offer(new int[]{nx, ny});
                } else {
                    swanQ.offer(new int[]{nx, ny});
                }
            }
        }
        swanQ = nextQ;
        return false;
    }

    private static void melt() {
        int size = meltQ.size();
        for (int i = 0; i < size; i++) {
            int x = meltQ.peek()[0];
            int y = meltQ.peek()[1];
            meltQ.poll();
            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                if (map[nx][ny] == 'X') {
                    map[nx][ny] = '.';
                    meltQ.offer(new int[]{nx, ny});
                }
            }
        }
    }
}