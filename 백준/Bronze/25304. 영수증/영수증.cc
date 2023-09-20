#include <iostream>

using namespace std;

int main()
{
    int sum = 0;
    int quan = 0;
    int a;
    int b;
    int c = 0;

    cin >> sum >> quan;

    for (int i = 0; i < quan; i++)
    {
        cin >> a >> b;
        c += (a * b);
    }

    if (sum == c)
        cout << "Yes" << endl;
    else
        cout << "No" << endl;
    





    return 0;
}