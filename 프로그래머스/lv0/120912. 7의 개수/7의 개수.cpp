#include <vector>
#include <string>
#include <algorithm>
#include <sstream>
#include <iterator>

using namespace std;
int solution(vector<int> array)
{
    int count = 0;
    stringstream result;
    copy(array.begin(), array.end(), ostream_iterator<int>(result, ""));
    string n = result.str();

    for (int i = 0; i < n.size(); i++)
    {
        if (n[i] == '7')
            count++;
    }
    

    return count;
}