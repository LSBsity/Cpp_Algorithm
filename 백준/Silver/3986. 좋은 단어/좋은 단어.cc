#include <bits/stdc++.h>

using namespace std;

int solve(const string &str) {
    stack<char> stk;

    for (char c: str) {
        if (stk.size() && stk.top() == c)
            stk.pop();
        else
            stk.push(c);
    }

    return stk.empty() ? 1 : 0;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int n, sum = 0;
    cin >> n;

    for (int i = 0; i < n; i++) {
        string str;
        cin >> str;

        sum += solve(str);
    }

    cout << sum;
}
