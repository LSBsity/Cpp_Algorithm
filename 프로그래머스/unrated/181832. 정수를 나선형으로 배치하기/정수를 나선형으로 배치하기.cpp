#include <string>
#include <vector>

using namespace std;
vector<vector<int>> solution(int n)
{
    vector<vector<int>> arr(n, vector(n, 0));
    int i, j, colwall, rowwall;
    i = j = colwall = rowwall = 0;
    
    int row = n;
    int col = n;
    
    int count = 1;
    while (count <= n * n)
    {
        while (i < row)
        {
            arr[j][i] = count;
            count++;
            i++;
        }
        i--;
        j++;
        row--;
        while (j < col)
        {
            arr[j][i] = count;
            count++;
            j++;
        }
        colwall++;
        i--;
        j--;
        col--;
        while (i >= rowwall)
        {
            arr[j][i] = count;
            count++;
            i--;
        }
        rowwall++;
        i++;
        j--;
        while (j >= colwall)
        {
            arr[j][i] = count;
            count++;
            j--;
        }
        j++;
        i++;
    }
    return arr;
}
