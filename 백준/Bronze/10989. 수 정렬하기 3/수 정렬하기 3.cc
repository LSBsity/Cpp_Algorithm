#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

int arr[10001];

int main(void)
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int a;
    cin >> a;

    for (int i = 0; i < a; i++)
    {
        int z;
        cin >> z;
        arr[z]++;
    }

    for (int i = 0; i < 10001; i++)
    {
        for (int j = 0; j < arr[i]; j++)
            cout << i << "\n";
    }

    return 0;
}