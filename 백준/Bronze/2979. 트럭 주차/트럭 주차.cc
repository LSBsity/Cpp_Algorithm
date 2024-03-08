#include <bits/stdc++.h>

using namespace std;

int fee[4];
int times[101];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    for (int i = 0; i < 3; i++)
        cin >> fee[i + 1];

    int sum = 0;

    for (int i = 0; i < 3; i++) {
        int a, b;
        cin >> a >> b;
        for (int j = a; j < b; j++)
            times[j]++;
    }

    for (int i = 1; i < 101; i++) {
        sum += fee[times[i]] * times[i];
    }

    cout << sum;

}

