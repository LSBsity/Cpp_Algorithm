import java.util.*;

class Solution {
    static char[][] map;
    static int n, m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        map = new char[n][];
        for (int i = 0; i < n; i++) map[i] = storage[i].toCharArray();

        for (String request : requests) {
            char c = request.charAt(0);
            if (request.length() == 1) {          
                boolean[][] out = markOutside();
                List<int[]> targets = new ArrayList<>();
                for (int i = 0; i < n; i++)
                    for (int j = 0; j < m; j++)
                        if (map[i][j] == c && touchOutside(i, j, out))
                            targets.add(new int[]{i, j});
                for (int[] t : targets) map[t[0]][t[1]] = ' ';
            } else {                             
                for (int i = 0; i < n; i++)
                    for (int j = 0; j < m; j++)
                        if (map[i][j] == c) map[i][j] = ' ';
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (map[i][j] != ' ') answer++;
        return answer;
    }

    private boolean[][] markOutside() {
        boolean[][] vis = new boolean[n + 2][m + 2];
        Deque<int[]> q = new ArrayDeque<>();
        vis[0][0] = true;
        q.add(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d], ny = cur[1] + dy[d];
                if (nx < 0 || ny < 0 || nx > n + 1 || ny > m + 1) continue;
                if (vis[nx][ny]) continue;
                boolean pad = (nx == 0 || ny == 0 || nx == n + 1 || ny == m + 1);
                if (!pad && map[nx - 1][ny - 1] != ' ') continue;
                vis[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
        return vis;
    }

    private boolean touchOutside(int i, int j, boolean[][] out) {
        for (int d = 0; d < 4; d++)
            if (out[i + 1 + dx[d]][j + 1 + dy[d]]) return true;
        return false;
    }
}