#include <string>
#include <vector>
#include <boost/algorithm/string.hpp>
using namespace std;

int solution(string myString, string pat) {
    boost::to_lower(myString);
    boost::to_lower(pat);
    return (myString.find(pat) != string::npos);
}