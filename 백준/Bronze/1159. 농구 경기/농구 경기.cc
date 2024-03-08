#include <bits/stdc++.h>

using namespace std;

int arr[26];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int cnt;
    cin >> cnt;

    for (int i = 0; i < cnt; i++) {
        string str;
        cin >> str;
        arr[str[0] - 'a']++;
    }

    int check = 0;
    for (int i = 0; i < 26; i++) {
        if (arr[i] >= 5) {
            cout << (char) ('a' + i);
            check = 1;
        }
    }

    if (!check)
        cout << "PREDAJA";

    return 0;
}