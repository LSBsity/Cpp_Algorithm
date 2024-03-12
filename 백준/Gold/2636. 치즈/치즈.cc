#include <bits/stdc++.h>

using namespace std;

int n, m, quan, cnt = 0, times = 0;

int arr[101][101];
int visited[101][101];
int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};


void go(int y, int x) {
    visited[y][x] = 1;
    for (int i = 0; i < 4; i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];
        if (ny < 0 || ny >= n || nx < 0 || nx >= m || visited[ny][nx] == 1) continue;
        if (arr[ny][nx] == 1) arr[ny][nx] = 2;
        if (arr[ny][nx] == 0) go(ny, nx);
    }
}

pair<int, int> check() {
    int ret = 0;
    int check = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (arr[i][j] == 2) {
                arr[i][j] = 0;
                ret++;
            }
            if (arr[i][j] == 1) {
                check = 1;
            }
        }
    }
    return {ret, check};
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n >> m;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> arr[i][j];
        }
    }


    while (1) {
        memset(visited, 0, sizeof(visited));
        times++;
        go(0, 0);
        tie(cnt, quan) = check();
        if (quan == 0) break;
    }

    cout << times << "\n";
    cout << cnt << "\n";

    return 0;
}