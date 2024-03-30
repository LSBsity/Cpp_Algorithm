#include <bits/stdc++.h>

using namespace std;

vector<int> num;
vector<char> oper_str;
int N, res = INT_MIN;
string str;

int oper(char op, int one, int two) {
    if (op == '+') return one + two;
    if (op == '-') return one - two;
    return one * two;
}

void go(int here, int _num) {
    if (here == num.size() - 1) {
        res = max(res, _num);
        return;
    }

    go(here + 1, oper(oper_str[here], _num, num[here + 1]));

    if (here + 2 <= num.size() - 1) {
        int temp = oper(oper_str[here + 1], num[here + 1], num[here + 2]);
        go(here + 2, oper(oper_str[here], _num, temp));
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> N >> str;

    for (int i = 0; i < str.size(); i++) {
        if (i & 1) oper_str.push_back(str[i]);
        else num.push_back(str[i] - '0');
    }
    go(0, num[0]);

    cout << res << "\n";

    return 0;
}

