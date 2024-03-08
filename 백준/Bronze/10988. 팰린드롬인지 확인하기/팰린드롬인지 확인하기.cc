#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    string str;
    stack<char> s;
    queue<char> q;

    cin >> str;

    for (const auto &item: str) {
        s.push(item);
        q.push(item);
    }

    for (const auto &item: str) {
        if (s.top() != q.front()) {
            cout << "0";
            return 0;
        }
        s.pop();
        q.pop();
    }
    cout << "1";
}