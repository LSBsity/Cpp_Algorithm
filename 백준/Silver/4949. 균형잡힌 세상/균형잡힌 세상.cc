#include <bits/stdc++.h>

using namespace std;

string check(string str) {
    stack<char> stk;
    for (char i: str) {
        if (i == '(' || i == '[') {
            stk.push(i);
        } else if (i == ')' || i == ']') {
            if (!stk.empty() && stk.top() == '(' && i == ')') {
                stk.pop();
            } else if (!stk.empty() && stk.top() == '[' && i == ']') {
                stk.pop();
            } else {
                return "no";
            }
        }
    }
    if (str.back() != '.') return "no";

    return !stk.empty() ? "no" : "yes";
}


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    while (1) {
        string str;
        getline(cin, str);
        if (str == ".") {
            break;
        }
        cout << check(str) << "\n";
    }

}