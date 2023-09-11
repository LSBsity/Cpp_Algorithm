#include <string>
#include <vector>

using namespace std;

string solution(string str) {
    string answer = "";
    
    for (int i = 0; i < str.size(); i++)
    {
        if (str[i] == 'm')
            answer += "rn";
        else
            answer += str[i];
    }
    
    return answer;
}