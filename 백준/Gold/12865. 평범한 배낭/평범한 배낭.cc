#include <bits/stdc++.h>

using namespace std;

int n, totalWeight, weight, value;
int dp[100001];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n >> totalWeight;

    while (n--) {
        cin >> weight >> value;
        for (int j = totalWeight; j >= weight; j--) {
            dp[j] = max(dp[j], dp[j - weight] + value);
        }
    }

    cout << dp[totalWeight] << "\n";

    return 0;
}