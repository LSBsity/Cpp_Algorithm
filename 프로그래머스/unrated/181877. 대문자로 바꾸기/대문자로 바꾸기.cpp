#include <string>
#include <vector>
#include <boost/algorithm/string.hpp>

using namespace std;

string solution(string myString) {
    boost::to_upper(myString);
    return myString;
}