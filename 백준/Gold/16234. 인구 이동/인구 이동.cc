#include <bits/stdc++.h>

using namespace std;

int n, l, r, arr[51][51], visited[51][51], gap, sum, ret = 0;

int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};

vector<pair<int, int>> v;

void go(int y, int x, vector<pair<int, int>> &v) {
    queue<pair<int, int>> q;
    q.push({y, x});

    while (!q.empty()) {
        tie(y, x) = q.front(), q.pop();
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || ny >= n || nx < 0 || nx >= n || visited[ny][nx]) continue;
            gap = arr[ny][nx] > arr[y][x] ? arr[ny][nx] - arr[y][x] : arr[y][x] - arr[ny][nx];
            if (l <= gap && gap <= r) {
                visited[ny][nx] = 1;
                v.push_back({ny, nx});
                sum += arr[ny][nx];
                q.push({ny, nx});
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n >> l >> r;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> arr[i][j];
        }
    }

    while (true) {
        int flag = 0;
        memset(visited, 0, sizeof(visited));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    v.clear(), v.push_back({i, j});
                    visited[i][j] = 1;
                    sum = arr[i][j];
                    go(i, j, v);

                    if (v.size() == 1) continue;
                    for (auto i: v) {
                        arr[i.first][i.second] = sum / v.size();
                        flag = 1;
                    }
                }
            }
        }
        
        if (!flag) break;
        ret++;
    }
    
    cout << ret << "\n";

    return 0;
}