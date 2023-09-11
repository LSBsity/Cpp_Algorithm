#include <string>
#include <vector>
#include <algorithm>
using namespace std;

vector<string> solution(vector<string> str_list) {
    vector<string> answer;
    
    auto itL = find(str_list.begin(), str_list.end(), "l");
    auto itR = find(str_list.begin(), str_list.end(), "r");
    
    if (itL == str_list.end() && itR == str_list.end())
        return answer;
    else if (itL == str_list.end())
        answer.assign(itR + 1, str_list.end());
    else if (itR == str_list.end())
        answer.assign(str_list.begin(), itL);
    else if (itL == str_list.begin() || itR == str_list.end())
        return answer;
    else
        itL < itR ? answer.assign(str_list.begin(), itL) : answer.assign(itR + 1, str_list.end());

    return answer;
}