#include <bits/stdc++.h>

using namespace std;

vector<string> res;
int n;

bool comp(string a, string b) {
    if (a.size() == b.size()) return a < b;
    return a.size() < b.size();
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n;

    for (int i = 0; i < n; i++) {
        string str;
        cin >> str;

        for (int i = 0; i < str.size(); i++) {
            if (isalpha(str[i]))
                str[i] = ' ';
        }

        stringstream ss;
        ss.str(str);
        string s;

        while (ss >> s) {
            while (1) {
                if (s.size() && s.front() == '0') s.erase(s.begin());
                else break;
            }
            if (!s.size()) res.push_back("0");
            else res.push_back(s);
        }

    }
    sort(res.begin(), res.end(), comp);
    for (int i = 0; i < res.size(); i++) {
        cout << res[i] << '\n';
    }
    return 0;
}
