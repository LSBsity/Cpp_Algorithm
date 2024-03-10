#include <bits/stdc++.h>

using namespace std;

int t, n;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> t;

    while (t--) {
        cin >> n;
        int a = 0, b = 0;
        for (int i = 2; i <= n; i *= 2)
            a += n / i;
        for (int j = 5; j <= n; j *= 5)
            b += n / j;
        cout << min(a, b) << "\n";
    }

    return 0;
}