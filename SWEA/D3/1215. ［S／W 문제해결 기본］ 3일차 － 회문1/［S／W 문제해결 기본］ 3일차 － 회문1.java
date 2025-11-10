import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int T, N;
    static char[][] arr;

    static int cnt;

    public static void main(String[] args) throws Exception {
        T = 10;

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new char[8][8];
            cnt = 0;

            for (int i = 0; i < 8; i++) {
                char[] chars = br.readLine().toCharArray();
                for (int j = 0; j < 8; j++) {
                    arr[i][j] = chars[j];
                }
            }

            if (N == 1) {
                cnt = 8 * 8;
            } else {
                go();
            }

            sb.append('#')
                    .append(t)
                    .append(' ')
                    .append(cnt / 2)
                    .append('\n');
        }

        System.out.println(sb);
    }

    private static void go() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                for (int d = 0; d < 4; d++) {
                    if (go(i, j, d)) {
                        cnt++;
                    }
                }
            }
        }
    }

    private static boolean go(int x, int y, int dir) {
        Deque<Character> deque = new ArrayDeque<>();
        deque.offer(arr[x][y]);

        for (int i = 0; i < N - 1; i++) {
            x += dx[dir];
            y += dy[dir];
            if (x < 0 || y < 0 || x >= 8 || y >= 8) return false;
            deque.offer(arr[x][y]);
        }
        while (!deque.isEmpty()) {
            Character first = deque.pollFirst();
            Character last = deque.pollLast();
            if (first != last) return false;

            if (deque.size() == 1) return true;
        }

        return true;
    }
}
