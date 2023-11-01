#include <string>
#include <vector>

using namespace std;

string solution(vector<string> cards1, vector<string> cards2, vector<string> goal) {
    bool check = false;
    int j = 0 , k = 0;
    
    for (int i = 0; i < goal.size(); i++)
    {
        if (goal[i] == cards1[j])
        {
            j++;
            check = true;
            continue;
        }
        else if (goal[i] == cards2[k])
        {
            k++;
            check = true;
            continue;
        }
    }
    if (j + k < goal.size())
        return "No";
    
    return check ? "Yes" : "No";
}