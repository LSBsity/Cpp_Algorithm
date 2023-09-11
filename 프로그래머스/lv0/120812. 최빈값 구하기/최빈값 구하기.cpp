#include <string>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;
map<int, int> mp;

bool cmp(const pair<int, int> &a, const pair<int, int> &b)
{
    if (a.second == b.second)
        return a.first > b.first;
    return a.second > b.second;
}
int solution(vector<int> array)
{
    vector<int> temp = array;
    vector<int> cnt;
    temp.erase(unique(temp.begin(), temp.end()), temp.end());
    for (int i = 0; i < temp.size(); i++)
    {
        int A = temp[i];
        int count = 0;
        for (int j = 0; j < array.size(); j++)
        {
            if (A == array[j])
                count++;
        }
        cnt.push_back(count);
    }
    for (int i = 0; i < temp.size(); i++)
        mp.insert(make_pair(temp[i], cnt[i]));

    vector<pair<int,int>> vec(mp.begin(), mp.end());
    sort(vec.begin(), vec.end(), cmp);

    if (vec[0].second == vec[1].second)
        return -1;
    
    return vec[0].first;
}