#include <bits/stdc++.h>

using namespace std;

int arr[26];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    string name;

    cin >> name;

    for (char i: name) {
        arr[i - 'a']++;
    }

    for (const auto &item: arr) {
        cout << item << " ";
    }

}