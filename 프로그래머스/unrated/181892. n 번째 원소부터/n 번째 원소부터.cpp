#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> num_list, int n) {
    vector<int> answer(num_list.begin() + n - 1, num_list.end());
    return answer;
}