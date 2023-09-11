#include <string>
#include <vector>

using namespace std;

pair<int, int> RT;
pair<int, int> CF;
pair<int, int> JM;
pair<int, int> AN;

int check(int choices)
{
    int a = 0;
    if (choices == 1) a = 3;
    else if (choices == 2) a = 2;
    else if (choices == 3) a = 1;
    return a;
}

string solution(vector<string> survey, vector<int> choices)
{
    string answer = "";

    for (int i = 0; i < survey.size(); i++)
    {
        if (survey[i] == "RT" || survey[i] == "TR")
        {
            if (survey[i] == "RT")
                choices[i] > 4 ? RT.second += choices[i] % 4 : RT.first += check(choices[i]);
            else
                choices[i] > 4 ? RT.first += choices[i] % 4 : RT.second += check(choices[i]);
        }
        else if (survey[i] == "CF" || survey[i] == "FC")
        {
            if (survey[i] == "CF")
                choices[i] > 4 ? CF.second += choices[i] % 4 : CF.first += check(choices[i]);
            else
                choices[i] > 4 ? CF.first += choices[i] % 4 : CF.second += check(choices[i]);
        }
        else if (survey[i] == "JM" || survey[i] == "MJ")
        {
            if (survey[i] == "JM")
                choices[i] > 4 ? JM.second += choices[i] % 4 : JM.first += check(choices[i]);
            else
                choices[i] > 4 ? JM.first += choices[i] % 4 : JM.second += check(choices[i]);
        }
        else if (survey[i] == "AN" || survey[i] == "NA")
        {
            if (survey[i] == "AN")
                choices[i] > 4 ? AN.second += choices[i] % 4 : AN.first += check(choices[i]);
            else
                choices[i] > 4 ? AN.first += choices[i] % 4 : AN.second += check(choices[i]);
        }
    }
    if (RT.first < RT.second)
        answer += "T";
    else
        answer += "R";
    if (CF.first < CF.second)
        answer += "F";
    else
        answer += "C";
    if (JM.first < JM.second)    
        answer += "M";
    else
        answer += "J";
    if (AN.first < AN.second)
        answer += "N";
    else
        answer += "A";
    
    return answer;
}