#include <string>
#include <vector>

using namespace std;

vector<vector<int>> solution(vector<vector<int>> arr) {
    int col = arr.size();
    int row = arr[0].size();
    
    if (arr.size() < arr[0].size())
        col = arr[0].size();
    else if (arr.size() > arr[0].size())
        row = arr.size();
    else
        return arr;
    
    vector<vector<int>> answer(col, vector<int> (row, 0));
    
    for (int i = 0; i < arr.size(); i++)
        for (int j = 0; j < arr[0].size(); j++)
            answer[i][j] = arr[i][j];
    
    return answer;
}