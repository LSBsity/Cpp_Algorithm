#include <iostream>
#include <deque>
#include <vector>

#define endl '\n'
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int a, b;
    int count = 0;
    vector<int> arr;
    cin >> a >> b;

    for (int i = 0; i < a; i++)
    {
        int tmp;
        cin >> tmp;
        arr.push_back(tmp);
    }

    for (int i = arr.size() - 1; i >= 0; i--)
    {
        if (b >= arr[i] && b != 0)
        {
            count += b / arr[i];
            b %= arr[i];
        }
    }
    cout << count;

    return 0;
}