#include <iostream>
using namespace std;


int main()
{
    int a;
    cin >> a;

    int i = 1;
    int cnt = 1;

    while (a > i)
    {
        i += (6 * cnt);
        cnt++;
    }

    cout << cnt;

    return 0;
}