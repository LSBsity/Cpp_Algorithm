#include <string>
#include <vector>

using namespace std;

string solution(string code)
{
    string answer = "";

    int mode = 0;
    for (int i = 0; i < code.size(); i++)
    {
        if (mode == 0)
        {
            if (code[i] != '1')
            {
                if (!(i % 2))
                    answer += code[i];
            }
            else
                mode = 1;
        }
        else if (mode == 1)
        {
            if (code[i] != '1')
            {
                if (i % 2)
                    answer += code[i];
            }
            else
                mode = 0;
        }
    }
    if (!answer.size())
        answer = "EMPTY";

    return answer;
}