#include <iostream>
#include <algorithm>
#include <vector>

#define endl '\n'
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int a;
    int sum = 0;
    vector<int> arr;
    cin >> a;

    for (int i = 0; i < a; i++)
    {
        int tmp;
        cin >> tmp;
        arr.push_back(tmp);
    }

    sort(arr.begin(), arr.end());


    for (int i = 0; i < arr.size(); i++)
    {
        for (int j = 0; j < i + 1; j++)
            sum += arr[j];
    }
    
    cout << sum;

    return 0;
}
