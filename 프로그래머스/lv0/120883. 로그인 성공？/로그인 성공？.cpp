#include <string>
#include <vector>

using namespace std;

string solution(vector<string> id_pw, vector<vector<string>> db)
{
    string answer = " ";
    bool IDs = false;
    bool PWs = false;
    bool log = false;
    string ID = id_pw[0];
    string PW = id_pw[1];

    for (int i = 0; i < db.size(); i++)
    {
        if (ID == db[i][0] && PW == db[i][1])
            log =true;
        else if (ID == db[i][0])
            IDs = true;
        else if (PW == db[i][1])
            PWs = true;

    }

    if (log == true)
        answer = "login";
    else if (IDs == false) 
        answer = "fail";
    else
        answer = "wrong pw";
    

    return answer;
}
