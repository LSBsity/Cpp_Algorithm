#include <string>
#include <vector>

using namespace std;

string solution(string n_str) {
    string answer = "";
    int count = 0;
    for (int i = 0; i < n_str.size(); i++)
    {
        if (n_str[i] == '0')
            count++;
        else
            break;
    }
    
    if (count >= 1)
        answer = n_str.substr(count,n_str.size());
    else
        answer = n_str;
    
    return answer;
}