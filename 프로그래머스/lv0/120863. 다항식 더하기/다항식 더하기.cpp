#include <string>
#include <vector>
#include <sstream>

using namespace std;
string arr[50];

string solution(string polynomial)
{
    string answer = "";
    int count = 0;
    int x = 0, y = 0;

    stringstream ss;
    ss.str(polynomial);

    while (ss >> arr[count])
    {
        count++;
    }

    for (int i = 0; i < count; i++)
    {
        if (arr[i][arr[i].size() - 1] == 'x')
        {
            if (arr[i].size() == 1)
                x += 1;
            else
                x += stoi(arr[i].substr(0, arr[i].size() - 1));
        }

        else if (arr[i][arr[i].size() - 1] == '+')
            continue;
        else
            y += stoi(arr[i]);
    }

    if (x > 0)
    {
        if (x == 1)
            answer += "x";
        else
            answer += to_string(x) + "x";
    }

    if (y > 0)
    {
        if (answer != "")
            answer += (" + " + to_string(y));
        else
            answer += (to_string(y));
    }

    if (answer == "")
        answer = "0";

    return answer;
}

