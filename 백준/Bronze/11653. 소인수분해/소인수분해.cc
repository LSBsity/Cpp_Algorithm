#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <cmath>
using namespace std;

int main()
{
    int a;
    cin >> a;
    for (int i = 2; i <= a; i++)
    {
        while (a % i == 0)
        {
            a /= i;
            cout << i << "\n";
        }
    }

    return 0;
}