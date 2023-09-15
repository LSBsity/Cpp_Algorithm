#include <string>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

int solution(vector<int> p, int l)
{
    vector<pair<int, bool>> v;
    for (int i = 0; i < p.size(); i++)
        i != l ? v.push_back(make_pair(p[i], false)) : v.push_back(make_pair(p[i], true));
    
    int count = 0;
    while (!v.empty())
    {
        pair<int, bool> t = v[0];
        v.erase(v.begin());
        int sign = 1;
        for (int i = 0; i < v.size(); i++)
        {
            if (t.first < v[i].first)
            {
                v.push_back(t);
                sign = 0;
                break;
            }
        }                
        if (sign)
        {
            count++;
            if (t.second)
                break;
        }       
    }
    return count;
}