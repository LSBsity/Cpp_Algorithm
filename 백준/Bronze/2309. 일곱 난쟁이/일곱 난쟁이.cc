#include <iostream>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

int a[9] = {0,};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    for (int i = 0; i < 9; i++)
        cin >> a[i];

    sort(a, a + 9);

    do {
        int sum = 0;
        for (int i = 0; i < 7; i++) sum += a[i];

        if (sum == 100) break;
    } while (next_permutation(a, a + 9));

    for (int i = 0; i < 7; i++)
        cout << a[i] << "\n";

    return 0;
}


