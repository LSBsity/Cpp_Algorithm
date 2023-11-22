#include <iostream>

using namespace std;

void is_Palin(int n) {
    int i, result = 0, q, rem;
    q = n;
    while (q != 0) {
        rem = q % 10;
        result = result * 10 + rem;
        q /= 10;
    }
    if (n == result)
        cout << "yes\n";
    else
        cout << "no\n";
}

int main() {
    while (1) {
        int a;
        cin >> a;
        if (!a) break;
        is_Palin(a);
    }

    return 0;
}