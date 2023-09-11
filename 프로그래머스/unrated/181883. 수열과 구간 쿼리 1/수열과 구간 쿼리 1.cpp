#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr, vector<vector<int>> queries) {
    for (int i = 0; i < queries.size(); i++)
    {
        int from = queries[i][0];
        int to = queries[i][1];
        for (int j = from; j <= to; j++)
            arr[j]++;
    }
    return arr;
}