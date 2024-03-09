#include <bits/stdc++.h>

using namespace std;


int arr[101][101];
int visited[101][101];

int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};

int n, cnt, res = 1;

void dfs(int y, int x, int d) {
    visited[y][x] = 1;
    for (int i = 0; i < 4; i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];
        if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
        if (!visited[ny][nx] && arr[ny][nx] > d) {
            dfs(ny, nx, d);
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> arr[i][j];
        }
    }

    for (int d = 1; d < 101; d++) {
        memset(visited, 0, sizeof(visited));
        cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] > d && !visited[i][j]) {
                    dfs(i, j, d);
                    cnt++;
                }
            }
        }
        res = max(res, cnt);
    }
    cout << res << "\n";

    return 0;
}