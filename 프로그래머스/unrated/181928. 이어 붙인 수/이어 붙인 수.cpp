#include <string>
#include <vector>

using namespace std;

int solution(vector<int> num_list) {
    string oddSum, evenSum = "";

    for (int i = 0; i < num_list.size(); i++)
    {
        if (num_list[i] % 2) oddSum += to_string(num_list[i]);
        else evenSum += to_string(num_list[i]);
    }
    
    return stoi(oddSum) + stoi(evenSum);
}