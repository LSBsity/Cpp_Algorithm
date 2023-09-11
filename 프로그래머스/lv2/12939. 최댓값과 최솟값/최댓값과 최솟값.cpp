#include <string>
#include <vector>
#include <algorithm>
#include <sstream>
using namespace std;

string solution(string zz)
{
    string answer = "", tok = "";
    vector<int> vec;

    for (stringstream ss(zz); ss >> tok;)
        vec.push_back(stoi(tok));
        
    sort(vec.begin(), vec.end());

    answer += to_string(vec.front()) + ' ' + to_string(vec.back());

    return answer;
}