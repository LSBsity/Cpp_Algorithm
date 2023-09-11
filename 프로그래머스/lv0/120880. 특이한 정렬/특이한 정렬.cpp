#include <string>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

pair<int, int> mp;

bool compare(pair<int, int> a, pair<int, int> b)
{
    if (a.second == b.second)
        return a.first < b.first;
    else if (a.first == b.first)
        return a.second > b.second;
    else
        return a.first < b.first;
}

vector<int> solution(vector<int> numlist, int n)
{
    vector<int> temp = numlist;
    vector<pair<int, int> > v;
    vector<int> answer;

    for (int i = 0; i < numlist.size(); ++i)
    {
        if (n > numlist[i])
            numlist[i] = n - numlist[i];
        else if (n < numlist[i])
            numlist[i] = numlist[i] - n;
        else
            numlist[i] = 0;
    }
    
    for (int i = 0; i < numlist.size(); i++)
        v.push_back(make_pair(numlist[i],temp[i]));

    sort(v.begin(), v.end(), compare);

    for (int i = 0; i < numlist.size(); i++)
        answer.push_back(v[i].second);


    return answer;
}