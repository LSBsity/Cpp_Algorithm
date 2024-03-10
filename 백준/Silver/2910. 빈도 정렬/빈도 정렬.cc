#include <bits/stdc++.h>

using namespace std;

int n, c;
int arr[1001];
map<int, int> m, m_first;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n >> c;


    for (int i = 0; i < n; i++) {
        cin >> arr[i];
        m[arr[i]]++;
        if (!m_first[arr[i]]) m_first[arr[i]] = i + 1;
    }

    vector<pair<int, int>> v;
    for (auto p: m) {
        v.push_back({p.second, p.first});
    }

    sort(v.begin(), v.end(),
         [](const auto &a, const auto &b) {
             return a.first == b.first ?
                    m_first[a.second] < m_first[b.second] : a.first > b.first;
         });

    for (const auto &p: v)
        for (int i = 0; i < p.first; i++)
            cout << p.second << " ";


    return 0;
}