#include <bits/stdc++.h>

using namespace std;

int n;

void check(string str) {
    stack<char> stk;
    for (char i: str) {
        if (i == '(') {
            stk.push(i);
        } else if (i == ')') {
            if (stk.empty() || stk.top() != '(') {
                cout << "NO" << "\n";
                return;
            } else {
                stk.pop();
            }
        }
    }
    stk.empty() ? cout << "YES" << "\n" : cout << "NO" << "\n";
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n;

    for (int i = 0; i < n; i++) {
        string str = "";
        cin >> str;

        check(str);
    }

}