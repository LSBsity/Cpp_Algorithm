#include <bits/stdc++.h>

using namespace std;

const int INF = 987654321;

int n, m, sy, sx, ret, y, x;

int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};

int fire_check[1001][1001], person_check[1001][1001];

queue<pair<int, int>> q;
char arr[1001][1001];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n >> m;

    fill(&fire_check[0][0], &fire_check[0][0] + 1001 * 1001, INF);

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> arr[i][j];
            if (arr[i][j] == 'F') fire_check[i][j] = 1, q.push({i, j});
            else if (arr[i][j] == 'J') sy = i, sx = j;
        }
    }

    while (!q.empty()) {
        tie(y, x) = q.front(), q.pop();
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
            if (fire_check[ny][nx] != INF || arr[ny][nx] == '#') continue;
            fire_check[ny][nx] = fire_check[y][x] + 1;
            q.push({ny, nx});
        }
    }

    person_check[sy][sx] = 1;
    q.push({sy, sx});
    while (!q.empty()) {
        tie(y, x) = q.front(), q.pop();

        if (y == 0 || y == n - 1 || x == 0 || x == m - 1) {
            ret = person_check[y][x];
            break;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
            if (person_check[ny][nx] || arr[ny][nx] == '#') continue;
            if (fire_check[ny][nx] <= person_check[y][x] + 1) continue;
            person_check[ny][nx] = person_check[y][x] + 1;
            q.push({ny, nx});
        }
    }

    if (ret != 0) cout << ret << "\n";
    else cout << "IMPOSSIBLE \n";

    return 0;
}

