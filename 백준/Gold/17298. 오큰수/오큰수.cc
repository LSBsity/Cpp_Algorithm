#include <bits/stdc++.h>

using namespace std;


int n, t;
vector<int> v;
stack<pair<int, int>> stk;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n;
    vector<int> ans(n);

    for (int i = 0; i < n; i++) {
        cin >> t;
        v.push_back(t);
    }

    stk.push({0, v[0]});
    for (int i = 1; i < v.size(); i++) {
        if (!stk.empty() && stk.top().second < v[i]) {
            while (!stk.empty() && stk.top().second < v[i]) {
                ans[stk.top().first] = v[i];
                stk.pop();
            }
            stk.push({i, v[i]});
        } else {
            stk.push({i, v[i]});
        }
    }

    while (!stk.empty()) {
        ans[stk.top().first] = -1;
        stk.pop();
    }
    
    for (auto i: ans) {
        cout << i << " ";
    }

    return 0;
}