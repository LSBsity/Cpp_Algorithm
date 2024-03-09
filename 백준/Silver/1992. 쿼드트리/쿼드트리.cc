#include <bits/stdc++.h>

using namespace std;

int n;
int arr[101][101];

string go(int y, int x, int s) {
    if (s == 1) return to_string(arr[y][x]);

    char tmp = arr[y][x];
    string result = "";

    for (int i = y; i < y + s; i++) {
        for (int j = x; j < x + s; j++) {
            if (tmp != arr[i][j]) {
                result += '(';
                result += go(y, x, s / 2);
                result += go(y, x + s / 2, s / 2);
                result += go(y + s / 2, x, s / 2);
                result += go(y + s / 2, x + s / 2, s / 2);
                result += ')';
                return result;
            }
        }
    }

    return to_string(arr[y][x]);
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n;
    for (int i = 0; i < n; i++) {
        string s;
        cin >> s;
        for (int j = 0; j < n; j++) {
            arr[i][j] = s[j] - '0';
        }
    }

    cout << go(0, 0, n) << '\n';

}