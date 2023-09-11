#include <string>
#include <vector>

using namespace std;

vector<string> solution(vector<string> picture, int k) {
    vector<string> answer;
    
    for (int i = 0; i < picture.size(); i++)
    {
        string temp = "";
        for (int j = 0; j < picture[0].size(); j++)
        {
            int l = k;
            while(l--)
                temp.push_back(picture[i][j]);
        }
        int z = k;
        while(z--)
            answer.push_back(temp);
    }
    return answer;
}