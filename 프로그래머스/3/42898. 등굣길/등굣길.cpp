#include <string>
#include <vector>
#include <queue>
#include <tuple>
#include <string.h>

using namespace std;

int dy[] = {0, 1};
int dx[] = {1, 0};

int visited[104][104] = {0,};
int map[104][104] = {0,};
long long dp[104][104] = {0,};

int ny, nx, y, x, mod = 1000000007;

int solution(int m, int n, vector<vector<int>> p) {
    queue<pair<int, int>> q;

    for (int i = 0; i < p.size(); i++) {
        map[p[i][0] - 1][p[i][1] - 1] = -1;
    }

    q.push({0, 0});
    visited[0][0] = 1;
    dp[0][0] = 1;

    while (!q.empty()) {
        tie(y, x) = q.front(), q.pop();

        if (y == m - 1 && x == n - 1) break;

        for (int i = 0; i < 2; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || ny >= m || nx < 0 || nx >= n || map[ny][nx] == -1) continue;
            dp[ny][nx] += dp[y][x] % mod;
            if (visited[ny][nx]) continue;
            q.push({ny, nx});
            visited[ny][nx] = 1;
        }
    }

    return dp[m - 1][n - 1] % mod;
}