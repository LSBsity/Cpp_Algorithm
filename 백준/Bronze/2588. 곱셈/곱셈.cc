#include <iostream>
#include <cstdlib>

using namespace std;

int main()
{
    int a;
    char b[4];

    cin >> a;
    cin >> b;

    cout << a * (b[2] - '0') << endl;
    cout << a * (b[1] - '0') << endl;
    cout << a * (b[0] - '0') << endl;
    cout << a * atoi(b) << endl;


    return 0;
}