#include <iostream>

using namespace std;

int main() {
    int c;
    cin >> c;
    int ans;
    if (c % 5 != 0) {
        cout << (c / 5) + 1 << endl;
    } else {
        cout << c / 5 << endl;
    }
}