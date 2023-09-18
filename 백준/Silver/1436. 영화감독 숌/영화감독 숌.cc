#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <climits>
using namespace std;

int main(void)
{
    int a;
    cin >> a;
    int i = 665;
    int count = 0;
    while (i++ <= INT_MAX)
    {
        string z = to_string(i);
        if (z.find("666") != string::npos) count++;
        if (count == a)
        {
            cout << z;
            return 0;
        }
    }

    return 0;
}