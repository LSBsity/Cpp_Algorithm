#include <bits/stdc++.h>

using namespace std;

int arr[101][101];
int visited[101][101];

int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};

int n, m, k, cnt = 0, areaSize;
vector<int> result;

void go(int y, int x) {
    visited[y][x] = 1;
    arr[y][x] = 1;
    areaSize++;
    for (int i = 0; i < 4; i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];
        if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
        if (!visited[ny][nx] && !arr[ny][nx]) {
            go(ny, nx);
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n >> m >> k;

    for (int i = 0; i < k; i++) {
        int a, b, c, d;
        cin >> a >> b >> c >> d;

        for (int j = a; j < c; j++) {
            for (int l = b; l < d; l++) {
                arr[l][j] = 1;
            }
        }

    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            areaSize = 0;
            if (!visited[i][j] && !arr[i][j]) {
                go(i, j);
                cnt++;
                result.push_back(areaSize);
            }
        }
    }

    sort(result.begin(), result.end());
    cout << cnt << "\n";
    for (int i: result) {
        cout << i << " ";
    }

}