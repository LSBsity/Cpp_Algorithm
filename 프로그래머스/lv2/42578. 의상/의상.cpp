#include <string>
#include <vector>
#include <unordered_map>
using namespace std;

int solution(vector<vector<string>> clothes)
{
    int answer = 1;
    unordered_map<string, int> m;
    for (const auto& cloth : clothes)
        m[cloth[1]]++;
    
    for (auto &pair : m)
        answer *= (pair.second + 1);

    return answer - 1;
}