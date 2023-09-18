#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

int main(void)
{
    vector<int> arr;
    int a, temp;
    cin >> a;
    for (int i = 0; i < a; i++)
    {
        cin >> temp;
        arr.push_back(temp);
    }
    sort(arr.begin(), arr.end());

    for (int i = 0; i < a; i++)
        cout << arr[i] << "\n";
}