#include <bits/stdc++.h>

using namespace std;

int arr[9][9], visited[9][9], n, m, mx = 0;
vector<pair<int, int>> virusList, wallList;

int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};

void dfs(int y, int x) {
    for (int i = 0; i < 4; i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];
        if (ny < 0 || ny >= n || nx < 0 || nx >= m || arr[ny][nx] == 1) continue;
        if (!visited[ny][nx]) {
            visited[ny][nx] = 1;
            dfs(ny, nx);
        }
    }
}

int solve() {
    memset(visited, 0, sizeof(visited));
    for (auto p: virusList) {
        visited[p.first][p.second] = 1;
        dfs(p.first, p.second);
    }

    int cnt = 0;
    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            if (arr[i][j] == 0 && !visited[i][j]) cnt++;

    return cnt;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n >> m;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> arr[i][j];

            if (arr[i][j] == 2) virusList.push_back({i, j});
            if (arr[i][j] == 0) wallList.push_back({i, j});
        }
    }

    for (int i = 0; i < wallList.size(); i++) {
        for (int j = 0; j < i; j++) {
            for (int k = 0; k < j; k++) {
                arr[wallList[i].first][wallList[i].second] = 1;
                arr[wallList[j].first][wallList[j].second] = 1;
                arr[wallList[k].first][wallList[k].second] = 1;
                mx = max(mx, solve());
                arr[wallList[i].first][wallList[i].second] = 0;
                arr[wallList[j].first][wallList[j].second] = 0;
                arr[wallList[k].first][wallList[k].second] = 0;
            }
        }
    }
    cout << mx << "\n";

    return 0;
}

