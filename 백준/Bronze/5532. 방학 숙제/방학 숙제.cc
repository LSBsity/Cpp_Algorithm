#include <iostream>
using namespace std;
int main() {
    int l, a, b, c, d,ans1,ans2;
    cin >> l >> a >> b >> c >> d;
    ans1 = a / c;
    a %= c;
    if (a > 0)ans1++;
    
    ans2 = b / d;
    b %= d;
    if (b > 0)ans2++;
    printf("%d\n", ans1 < ans2 ? l - ans2 : l - ans1);
}