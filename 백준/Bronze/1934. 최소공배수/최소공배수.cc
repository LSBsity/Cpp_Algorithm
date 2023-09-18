#include <iostream>

using namespace std;

int euclid(int a, int b)
{
    if (a % b == 0) return b;

    return euclid(b, a % b);
}

int lcm(int a, int b)
{
    return a * b / euclid(a, b);
}

int main()
{
    int a;
    cin >> a;

    for (int i = 0; i < a; i++)
    {
        int b, c;
        cin >> b >> c;
        cout << lcm(b, c) << '\n';
    }
    


    return 0;
}
