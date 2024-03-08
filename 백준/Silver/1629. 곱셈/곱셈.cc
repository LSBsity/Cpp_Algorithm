#include <bits/stdc++.h>

using namespace std;

typedef long long ll;

ll a, b, c;

ll divide(ll a, ll b, ll c) {
    if (b == 1)
        return a % c;
    
    ll tmp = divide(a, b / 2, c) % c;

    if (b % 2 == 0)
        return tmp * tmp % c;
    else
        return tmp * tmp % c * a % c;

}


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> a >> b >> c;

    cout << divide(a, b, c);

    return 0;
}