#include <string>
#include <vector>

using namespace std;

vector<vector<int>> solution(vector<int> num_list, int n)
{
    vector<vector<int>> v(num_list.size()/n, vector<int>(n, 0));


    int z = 0;
    for (int i = 0; i < num_list.size() / n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            v[i][j] = num_list[z];
            z++;
        }   
    }

    return v;
}