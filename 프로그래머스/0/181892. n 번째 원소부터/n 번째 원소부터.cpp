#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> num_list, int n) {
    return {num_list.begin() + n - 1, num_list.end()};
}