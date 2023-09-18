#include <iostream>
using namespace std;

int main()
{

    int a, b, c;
    cin >> a >> b >> c;

    if (a != b && b != c && a != c)
    {
        int max;

        if (a > b)
        {

            if (c > a)
            {
                max = c;
            }

            else
            {
                max = a;
            }
        }

        else
        {

            if (c > b)
            {
                max = c;
            }

            else
            {
                max = b;
            }
        }
        cout << max * 100;
    }

    else
    {

        if (a == b && a == c)
        {
            cout << 10000 + a * 1000;
        }
        else
        {

            if (a == b || a == c)
            {
                cout << 1000 + a * 100;
            }

            else
            {
                cout << 1000 + b * 100;
            }
        }
    }

    return 0;
}