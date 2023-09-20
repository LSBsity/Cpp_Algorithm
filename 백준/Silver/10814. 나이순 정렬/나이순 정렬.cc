#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#define endl '\n'
using namespace std;

bool cmp(pair<string, int> a, pair<string, int> b)
{
    return a.second < b.second;
}

int main()
{
    cin.tie(0)->sync_with_stdio(0);
    int a;
    vector<pair<string, int>> arr;
    cin >> a;

    for (int i = 0; i < a; i++)
    {
        int z;
        string s;
        cin >> z >> s;
        arr.push_back(make_pair(s, z));
    }
    stable_sort(arr.begin(), arr.end(), cmp);

    for (int i = 0; i < arr.size(); i++)
        cout << arr[i].second << " " << arr[i].first << endl;

    return 0;
}
