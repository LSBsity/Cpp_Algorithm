#include <bits/stdc++.h>

#define prev asdf
using namespace std;

int n, o, A, B, asum, bsum;
string s, prev;

string print(int a) {
    string h = "00" + to_string(a / 60);
    string m = "00" + to_string(a % 60);

    return h.substr(h.size() - 2, 2) + ":" + m.substr(m.size() - 2, 2);
}

int toInt(string a) {
    return atoi(a.substr(0, 2).c_str()) * 60 + atoi(a.substr(3, 2).c_str());
}

void calc(int &sum, string s) {
    sum += (toInt(s) - toInt(prev));
}


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> o >> s;

        if (A > B) calc(asum, s);
        else if (B > A) calc(bsum, s);

        o == 1 ? A++ : B++;
        prev = s;
    }

    if (A > B) calc(asum, "48:00");
    else if (B > A) calc(bsum, "48:00");

    cout << print(asum) << "\n";
    cout << print(bsum) << "\n";
}