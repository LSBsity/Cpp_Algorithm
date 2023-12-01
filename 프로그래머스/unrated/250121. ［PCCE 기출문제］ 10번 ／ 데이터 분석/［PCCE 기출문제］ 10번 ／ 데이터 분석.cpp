#include <string>
#include <vector>
#include <algorithm>
using namespace std;
int sortBy;

int extract(string a) {
    if (a == "code")
        return 0;
    if (a == "date")
        return 1;
    if (a == "maximum")
        return 2;
    return 3;
}

bool comp(vector<int> a, vector<int> b) {
    return a[sortBy] < b[sortBy];
}

vector<vector<int>> solution(vector<vector<int>> data, string a, int b, string c) {
    vector<vector<int>> answer;
    int ext = extract(a);
    sortBy = extract(c);
    
    for (int i = 0; i < data.size(); i++) {
        if (data[i][ext] < b)
            answer.push_back(data[i]);
    }
    
    sort(answer.begin(), answer.end(), comp);
    
    return answer;
}