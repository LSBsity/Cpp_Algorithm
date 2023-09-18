#include <iostream>


using namespace std;

int main()
{
    int a , b;

    cin >> a >> b;

    if (b < 45)
    {
        b += 15;
        a--;
    }
    else
        b -= 45;
    if (a < 0)
        a = 23;
    cout << a << " " << b;

    return 0;
}
