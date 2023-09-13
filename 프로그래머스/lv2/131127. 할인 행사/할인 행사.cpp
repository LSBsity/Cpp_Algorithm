#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<string> want, vector<int> number, vector<string> discount)
{
    int cnt = 0;
    vector<string> v;

    for (int i = 0; i < number.size(); i++)
        for (int j = 0; j < number[i]; j++)
            v.push_back(want[i]);

    sort(v.begin(), v.end());
    
    for (int i = 0; i <= discount.size() - v.size(); i++)
    {
        vector<string> dis(discount.begin() + i, discount.begin() + i + 10);
        sort(dis.begin(), dis.end());
        
        bool sign = true;
        int count = v.size();
        for (int j = 0; j < v.size(); j++)
        {
            if (v[j] != dis[j])
                sign = false;
            else
                count--;
        }
        if (sign && !count)
            cnt++;
    }
    return cnt;
}
