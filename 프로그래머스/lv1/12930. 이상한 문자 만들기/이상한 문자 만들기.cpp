#include <string>
#include <vector>

using namespace std;

string solution(string s)
{
    int count = 0;
    for (int i = 0; i < s.length(); i++)
    {
        if (islower(s[i]) && count % 2 == 0)
            s[i] = toupper(s[i]);
        if (isupper(s[i]) && count % 2 == 1)
            s[i] = tolower(s[i]);
        count++;
        if (s[i] == ' ')
            count = 0;
    }

    return s;
}