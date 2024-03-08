#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int n;
    string pat, fir, sec;
    cin >> n;
    cin >> pat;

    size_t pos = pat.find("*");

    fir = pat.substr(0, pos);
    sec = pat.substr(pos + 1);


    for (int i = 0; i < n; i++) {
        string str, a, b;
        cin >> str;

        if (fir.size() + sec.size() > str.size()) {
            cout << "NE\n";
            continue;
        }
        
        a = str.substr(0, fir.size());
        b = str.substr(str.size() - sec.size());
        
        a == fir && b == sec ? cout << "DA\n" : cout << "NE\n";
    }

}