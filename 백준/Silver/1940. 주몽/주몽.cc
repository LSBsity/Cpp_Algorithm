#include <bits/stdc++.h>

using namespace std;

int arr[15001];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int n, k, cnt = 0;
    cin >> n >> k;

    for (int i = 0; i < n; i++)
        cin >> arr[i];


    for (int i = 0; i < n; i++) {
        for (int j = 0; j < i; j++) {
            if (arr[i] + arr[j] == k) {
                cnt++;
            }
        }
    }

    cout << cnt;

    return 0;
}