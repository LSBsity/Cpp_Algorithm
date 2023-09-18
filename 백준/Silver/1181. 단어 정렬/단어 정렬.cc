#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#define endl '\n'
using namespace std;

bool cmp(string a, string b)
{
    if (a.length() == b.length())
        return a < b;
    else
        return a.length() < b.length();
}

int main()
{
    cin.tie(0)->sync_with_stdio(0);
    int a;
    vector<string> arr;
    cin >> a;

    for (int i = 0; i < a; i++)
    {
        string c;
        cin >> c;
        arr.push_back(c);
    }

    sort(arr.begin(), arr.end(), cmp);
    arr.erase(unique(arr.begin(), arr.end()), arr.end());
    for (int i = 0; i < arr.size(); i++)
        cout << arr[i] << endl;

    return 0;
}
