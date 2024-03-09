#include <bits/stdc++.h>

using namespace std;

int n, m, N, res = 0;
pair<int, int> pos;


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n >> m >> N;

    pos = {0, m - 1};

    for (int i = 0; i < N; i++) {
        int ap;
        cin >> ap;

        if (ap >= pos.first && ap <= pos.second) continue;
        else {
            if (ap >= pos.second) {
                while (pos.second != ap && pos.second <= n) {
                    pos.first++;
                    pos.second++;
                    res++;
                }
            } else {
                while (pos.first != ap && pos.first >= 0) {
                    pos.first--;
                    pos.second--;
                    res++;
                }
            }
        }
    }
    cout << res - 1 << '\n';
}