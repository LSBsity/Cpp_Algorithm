#include <iostream>
#include <map>
using namespace std;

map<string, int> mp;

int main(void)
{
    int a, b;
    int count = 0;
    cin >> a >> b;
    for (int i = 0; i < a; i++)
    {
        char tmp[501];
        scanf("%s", tmp);
        mp[tmp]++;
    }

    for (int i = 0; i < b; i++)
    {
        char tmp[501];
        scanf("%s", tmp);
        if (mp[tmp] >= 1) count++;
    }
    cout << count;

    return 0;
}