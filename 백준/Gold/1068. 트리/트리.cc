#include <bits/stdc++.h>

using namespace std;

int n, r, temp, root;
vector<int> v[54];

int dfs(int from) {
    int cnt = 0, child = 0;
    for (int to: v[from]) {
        if (to == r) {
            continue;
        }
        cnt += dfs(to);
        child++;
    }
    if (child == 0) return 1;
    return cnt;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> temp;
        if (temp == -1) root = i;
        else v[temp].push_back(i);
    }

    cin >> r;

    cout << (r == root ? "0" : to_string(dfs(root))) << "\n";

    return 0;
}

