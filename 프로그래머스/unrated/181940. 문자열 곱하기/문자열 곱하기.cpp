#include <string>
#include <vector>

using namespace std;

string solution(string my_string, int k) {
    string pat = my_string;
    for (int i = 0; i < k - 1; i++)
        my_string += pat;
    return my_string;
}