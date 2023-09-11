#include <string>
#include <vector>
#include <boost/algorithm/string.hpp>

using namespace std;

string solution(string myString) {
    boost::algorithm::to_lower(myString);
    return myString;
}