#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <cmath>
using namespace std;

int isPrime(int n)
{
    if (n <= 1)
        return 0;

    if (n % 2 == 0)
        return n == 2 ? 1 : 0;

    for (int i = 3; i <= sqrt(n); i += 2)
    {
        if (n % i == 0)
            return 0;
    }

    return 1;
}

int main(void)
{
    int a, b;
    cin >> a >> b;
    int sum = 0;
    int min = 0;
    for (int i = a; i <= b; i++)
    {
        if (isPrime(i) == 1)
        {
            sum += i;
            if (min == 0)
                min = i;
        }
    }
    if (sum == 0)
        cout << "-1" << endl;
    else
        cout << sum << "\n"
             << min;

    return 0;
}