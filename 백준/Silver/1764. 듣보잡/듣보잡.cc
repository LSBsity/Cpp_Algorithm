#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <map>
using namespace std;


int main(void)
{
    map<string, int> arr;
    vector<string> arr2;
    int a, b;
    string temp;
    cin >> a >> b;
    for (int i = 0; i < a; i++)
    {
        cin >> temp;
        arr[temp]++;
    }
    for (int i = 0; i < b; i++)
    {
        cin >> temp;
        if(arr[temp] >= 1)
            arr2.push_back(temp);
    }
    sort(arr2.begin(), arr2.end());
    cout << arr2.size() << "\n";
    for (int i = 0; i < arr2.size(); i++)
        cout << arr2[i] << "\n";

    return 0;
}