#include <string>
#include <vector>
#include <algorithm>
using namespace std;

vector<string> solution(string myString) {
    vector<string> answer;
    string temp = "";
    
    for (int i = 0; i < myString.size(); i++)
    {
        if (myString[i] == 'x' && temp != "")
        {
            answer.push_back(temp);
            temp = "";
        }
        else if (myString[i] != 'x')
            temp += myString[i];
    }
    if (temp.size() >= 1)
        answer.push_back(temp);
    
    sort(answer.begin(), answer.end());
    
    return answer;
}