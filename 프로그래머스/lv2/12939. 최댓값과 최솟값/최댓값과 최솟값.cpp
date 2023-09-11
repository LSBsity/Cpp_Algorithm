#include <string>
#include <vector>
#include <algorithm>
#include <sstream>
using namespace std;

string solution(string s)
{
    string answer = "", tok = "";
    vector<int> vec;

    for (stringstream ss(s); ss >> tok;)
        vec.push_back(stoi(tok));
        
    sort(vec.begin(), vec.end());

    answer += to_string(vec.front()) + ' ' + to_string(vec.back());

    return answer;
}