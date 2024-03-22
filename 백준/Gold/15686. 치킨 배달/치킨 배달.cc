#include <bits/stdc++.h>

using namespace std;

int n, m, arr[51][51], result = INT_MAX;
vector<vector<int>> chickenList;
vector<pair<int, int>> _home, chicken;

void combi(int s, vector<int> v) {
    if (v.size() == m) {
        chickenList.push_back(v);
        return;
    }
    for (int i = s + 1; i < chicken.size(); i++) {
        v.push_back(i);
        combi(i, v);
        v.pop_back();
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n >> m;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> arr[i][j];
            if (arr[i][j] == 1) _home.push_back({i, j});
            if (arr[i][j] == 2) chicken.push_back({i, j});
        }
    }

    vector<int> v;
    combi(-1, v);

    for (vector<int> cList: chickenList) {
        int ret = 0;
        for (pair<int, int> home: _home) {
            int _min = INT_MAX;
            for (int ch: cList) {
                int dist = abs(home.first - chicken[ch].first) + abs(home.second - chicken[ch].second);
                _min = min(_min, dist);
            }
            ret += _min;
        }
        result = min(result, ret);
    }

    cout << result << "\n";

    return 0;
}