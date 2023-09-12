#include <vector>
#include <algorithm>
#include <numeric>
using namespace std;

int solution(vector<int> v) {
    int answer = 0;
    int m[500501] = {0,};
    for (int i = 0; i < v.size(); i++)
    {   
        for (int j = 0; j < v.size(); j++) 
        {   
            int s = accumulate(v.begin(), v.begin() + i, 0);
            if (!m[s])
                answer++;
            m[s] = 1; 
            rotate(v.begin(), v.begin() + 1, v.end());
        }
    }
    return answer;
}