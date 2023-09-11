#include <string>
#include <vector>
#include <sstream>

using namespace std;

vector<string> solution(vector<string> quiz)
{
    vector<string> answer;
    for (int i = 0; i < quiz.size(); i++)
    {
        stringstream ss(quiz[i]);
        int init;
        ss >> init;
        char a, c;
        int b, d;

        while (ss >> a >> b >> c >> d)
        {
            if (a == '+')
            {
                init += b;
                if (init == d) answer.push_back("O");
                else answer.push_back("X");
            }
            else if (a == '-')
            {
                init -= b;
                if (init == d) answer.push_back("O");
                else answer.push_back("X");
            }
        }
    }

    return answer;
}