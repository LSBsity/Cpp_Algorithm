import java.io.*;
import java.util.*;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;

    static StringBuilder sb = new StringBuilder();

    static int T; // 테스트 케이스 수
    static int N; // 고객 수
    static int minDist; // 최소 거리 저장

    static int[] company = new int[2]; // 회사 좌표
    static int[] home = new int[2]; // 집 좌표
    static int[][] clients; // 고객 좌표

    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            clients = new int[N][2];
            visited = new boolean[N];
            minDist = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine());

            // 회사 좌표
            company[0] = Integer.parseInt(st.nextToken());
            company[1] = Integer.parseInt(st.nextToken());

            // 집 좌표
            home[0] = Integer.parseInt(st.nextToken());
            home[1] = Integer.parseInt(st.nextToken());

            // 고객 좌표 입력
            for (int i = 0; i < N; i++) {
                clients[i][0] = Integer.parseInt(st.nextToken());
                clients[i][1] = Integer.parseInt(st.nextToken());
            }

            // 완전탐색 시작
            dfs(0, company[0], company[1], 0);

            sb.append("#").append(t).append(" ").append(minDist).append("\n");
        }

        System.out.print(sb);
    }

    // depth : 방문한 고객 수
    // x, y : 현재 위치
    // dist : 지금까지의 거리
    static void dfs(int depth, int x, int y, int dist) {
        // 현재까지 거리가 이미 최소 거리보다 크면 더 볼 필요 없음 (가지치기)
        // if (dist >= minDist)
        //     return;

        // 모든 고객을 다 방문했으면 집까지 이동 후 최소값 갱신
        if (depth == N) {
            dist += Math.abs(x - home[0]) + Math.abs(y - home[1]);
            minDist = Math.min(minDist, dist);
            return;
        }

        // 방문하지 않은 고객 탐색
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int nx = clients[i][0];
                int ny = clients[i][1];
                dfs(depth + 1, nx, ny, dist + Math.abs(x - nx) + Math.abs(y - ny));
                visited[i] = false;
            }
        }
    }
}
