#include <string>
#include <vector>

using namespace std;

vector<int> solution(int l, int r) {
    vector<int> answer;
    
    for (int i = l; i <= r; i++)
    {
        string temp = to_string(i);
        int sign = 0;
        for (int j = 0; j < temp.size(); j++)
            if (temp[j] != '5' && temp[j] != '0')
                sign = 1;
        
        if (!sign)
            answer.push_back(i);
    }
    if (!answer.size())
        answer.push_back(-1);
    
    return answer;
}