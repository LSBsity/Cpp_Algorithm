#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

int main(void)
{
    vector<int> arr;
    int n;
    cin >> n;

    for (int i = 0; i < n; i++)
    {
        int a = 0;
        cin >> a;
        arr.push_back(a);
    }
    sort(arr.begin(), arr.end());

    for (int i = 0; i < arr.size(); i++)
        cout << arr[i] << endl;
    
}