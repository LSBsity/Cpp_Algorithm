#include <bits/stdc++.h>

using namespace std;

typedef long long ll;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);


    int i;
    while (scanf("%d", &i) != EOF) {

        ll cnt = 1, size = 1;

        while (1) {
            if (cnt % i == 0) {
                cout << size << "\n";
                break;
            }
            cnt = ((cnt * 10) + 1) % i;
            size++;
        }
    }


}