#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <map>
using namespace std;

int main(void)
{
    int a, b;
    string temp;
    map<string, int> mp;
    vector<string> name;
    vector<string> result;

    cin >> a >> b;
    for (int i = 1; i <= a; i++)
    {
        cin >> temp;
        name.push_back(temp);
        mp.insert(make_pair(temp, i));
    }
    for (int i = 0; i < b; i++)
    {
        cin >> temp;
        if (temp[0] >= 65 && temp[0] <= 90)
            result.push_back(to_string(mp[temp]));
        else
            result.push_back(name[stoi(temp) - 1]);
    }

    for (int i = 0; i < result.size(); i++)
        cout << result[i] << "\n";

    return 0;
}