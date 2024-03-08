#include <bits/stdc++.h>

using namespace std;


int solve() {
    int n, ret = 1;
    unordered_map<string, int> m;
    cin >> n;

    for (int i = 0; i < n; i++) {
        string a, b;
        cin >> a >> b;
        m[b]++;
    }

    for (auto &pair: m) {
        ret *= pair.second + 1;
    }

    return --ret;
}


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        cout << solve() << "\n";
    }


}