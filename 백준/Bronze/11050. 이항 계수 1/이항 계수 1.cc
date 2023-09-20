#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int Fac(int num)
{
    if (num == 1 || num == 0)
        return 1;
    else
        return Fac(num - 1) * num;
}

int main()
{
    int a, b;
    cin >> a >> b;

    cout << Fac(a) / (Fac(b) * Fac(a - b));
}