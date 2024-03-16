#include <bits/stdc++.h>

using namespace std;

int n, m, a, b, mx = -1;
vector<int> adj[10001];
int visited[10001];
int arr[10001];

int go(int from) {
    visited[from] = 1;
    int ret = 1;
    for (int to: adj[from]) {
        if (!visited[to]) {
            visited[to] = 1;
            ret += go(to);
        }
    }
    return ret;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n >> m;

    for (int i = 0; i < m; i++) {
        cin >> a >> b;
        adj[b].push_back(a);
    }

    for (int i = 1; i <= n; i++) {
        memset(visited, 0, sizeof(visited));
        arr[i] = go(i);
        mx = max(mx, arr[i]);
    }

    for (int i = 1; i <= n; i++) {
        if (mx == arr[i]) cout << i << " ";
    }
    cout << "\n";


    return 0;
}