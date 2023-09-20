#include <iostream>
#include <array>

using namespace std;

int main()
{
    int a;
    int b;

    while (!(a == 0 && b == 0))
    {
        cin >> a >> b;
        if (!(a == 0 && b == 0))
            cout << a + b << endl;
    }

    return 0;
}