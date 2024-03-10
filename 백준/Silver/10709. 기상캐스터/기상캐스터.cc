#include <bits/stdc++.h>

using namespace std;

int h, w;


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> h >> w;

    for (int i = 0; i < h; i++) {
        string str;
        cin >> str;

        vector<int> res(w, -1);

        int pos = -1;
        for (int j = 0; j < w; j++) {
            if (str[j] == 'c') {
                pos = j;
                res[j] = 0;
            } else if (pos != -1) {
                res[j] = j - pos;
            }
        }

        for (int j = 0; j < w; j++) {
            cout << res[j] << " ";
        }
        cout << "\n";
    }

    return 0;
}