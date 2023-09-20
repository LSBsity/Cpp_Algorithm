#include <iostream>
#include <algorithm>
#include <vector>

#define endl '\n'
using namespace std;

bool cmp(pair<int, int> a, pair<int, int> b)
{
    if (a.first == b.first) return a.second < b.second;
    else return a.first < b.first;
}

int main()
{
    cin.tie(0)->sync_with_stdio(0);
    int a, b, c;
    vector<pair<int, int>> v;
    cin >> a;

    for (int i = 0; i < a; i++)
    {
        cin >> b >> c;
        v.push_back(make_pair(b, c));
    }

    sort(v.begin(), v.end(), cmp);

    for (int i = 0; i < v.size(); i++)
        cout << v[i].first << " " << v[i].second << endl;
    
    return 0;
}

