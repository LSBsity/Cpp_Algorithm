#include <string>
#include <vector>

using namespace std;

string solution(string s, int n)
{
    string answer = "";

    for (int i = 0; i < s.length(); i++)
    {
        if (s[i] >= 65 && s[i] <= 90)
        {
            if (s[i] + n <= 90)
                answer += s[i] + n;
            else if (s[i] + n > 90)
                answer += 64 + (s[i] + n) - 90;
        }
        else if (s[i] >= 97 && s[i] <= 122)
        {
            if (s[i] + n <= 122)
                answer += s[i] + n;
            else if (s[i] + n > 122)
                answer += 96 + (s[i] + n) - 122;
        }
        else
            answer += " ";
    }
    
    return answer;
}