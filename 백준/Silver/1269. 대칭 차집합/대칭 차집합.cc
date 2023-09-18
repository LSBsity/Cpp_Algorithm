#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <map>
using namespace std;

int main(void)
{
    bool arr[100000001] = {false, };

    int a, b, tmp;
    int count = 0;
    cin >> a >> b;

    for (int i = 0; i < a; i++)
    {
        cin >> tmp;
        arr[tmp] = true;
    }
    for (int i = 0; i < b; i++)
    {
        cin >> tmp;
        if (arr[tmp] == true)
            count++;
    }

    cout << (a - count) + (b - count);

    return 0;
}