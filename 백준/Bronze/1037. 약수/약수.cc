#include <iostream>
#include <algorithm>
using namespace std;

int arr[51];
int main()
{
    int a;
    cin >> a;

    for (int i = 0; i < a; i++)
    {
        cin >> arr[i];
    }
    sort(arr, arr + a);

    int answer = arr[0] * arr[a - 1];

    cout << answer;

    return 0;
}
