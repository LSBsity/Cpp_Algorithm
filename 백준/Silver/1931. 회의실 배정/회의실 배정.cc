#include <bits/stdc++.h>

using namespace std;

int n, a, b, from, to, cnt = 1;

vector<pair<int, int>> v, ans;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> a >> b;
        v.push_back({b, a});
    }

    sort(v.begin(), v.end());

    from = v[0].second, to = v[0].first;
    ans.push_back({from, to});

    for (int i = 1; i < n; i++) {
        if (v[i].second < to) continue;
        from = v[i].second, to = v[i].first;
        cnt++;
    }

    cout << cnt << "\n";

    return 0;
}