#include <string>
#include <vector>
#include <boost/algorithm/string.hpp>

using namespace std;

vector<string> solution(vector<string> strArr) {

    for (int i = 0; i < strArr.size(); i++)
    {
        i % 2 == 0 ? boost::to_lower(strArr[i]) : boost::to_upper(strArr[i]);
    }
    
    return strArr;
}