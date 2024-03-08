#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    string str;
    getline(cin, str);

    for (char &item: str) {
        if (isalpha(item)) {
            if (isupper(item))
                item = 'A' + (item - 'A' + 13) % 26;
            else
                item = 'a' + (item - 'a' + 13) % 26;

        }
    }

    cout << str;

    return 0;
}
