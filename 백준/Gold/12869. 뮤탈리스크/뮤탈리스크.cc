#include <bits/stdc++.h>

using namespace std;

int n, a[3] = {9, 3, 1}, arr[3];
vector<vector<int>> _a;
int dp[64][64][64], visited[64][64][64];

struct A {
    int a, b, c;
};

queue<A> q;

void permutation(int *a, int depth) {
    if (depth == 3) {
        vector<int> t;
        for (int i = 0; i < 3; i++) {
            t.push_back(a[i]);
        }
        _a.push_back(t);
        return;
    }

    for (int i = depth; i < 3; i++) {
        swap(a[depth], a[i]);
        permutation(a, depth + 1);
        swap(a[depth], a[i]);
    }
}

int go(int a, int b, int c) {
    visited[a][b][c] = 1;
    q.push({a, b, c,});
    while (!q.empty()) {
        int a = q.front().a;
        int b = q.front().b;
        int c = q.front().c;
        q.pop();
        if (visited[0][0][0]) break;
        for (int i = 0; i < 6; i++) {
            int na = max(0, a - _a[i][0]);
            int nb = max(0, b - _a[i][1]);
            int nc = max(0, c - _a[i][2]);
            if (visited[na][nb][nc]) continue;
            visited[na][nb][nc] = visited[a][b][c] + 1;
            q.push({na, nb, nc});
        }
    }
    return visited[0][0][0] - 1;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n;
    for (int i = 0; i < n; i++) cin >> arr[i];

    permutation(a, 0);

    cout << go(arr[0], arr[1], arr[2]) << "\n";
    
    return 0;
}