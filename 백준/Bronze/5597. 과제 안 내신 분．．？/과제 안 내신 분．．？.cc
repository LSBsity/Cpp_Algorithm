#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

bool arr[31];
int main(void)
{
    int a;

    for (int i = 1; i <= 28; i++)
    {
        cin >> a;
        arr[a] = 1;
    }

    for (int i = 1; i <= 30; i++)
    {
        if (arr[i] == 0)
            cout << i << "\n";
    }

    return 0;
}