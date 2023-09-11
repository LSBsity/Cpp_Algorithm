#include <string>
#include <vector>
#include <cmath>
#include <algorithm>

using namespace std;


int calc(const int& number, const int& center)
{
    int ret_value = 4;
    if(center - number == 0)
        ret_value = 0;
    else if((abs(center - number) == 1) || (abs(center - number) == 3))
        ret_value = 1;
    else if((abs(center - number) == 2) || (abs(center - number) == 4) || (abs(center - number) == 6))
        ret_value = 2;
    else if((abs(center - number) == 5) || (abs(center - number) == 7) || (abs(center - number) == 9))
        ret_value = 3;
    return ret_value;
}

string solution(vector<int> numbers, string hand) {
    replace(numbers.begin(), numbers.end(), 0, 11);
    auto left_hand_position = 10, right_hand_position = 12;
    string answer = "";
    for(const auto& number : numbers)
    {
        if((number == 1) || (number == 4) || (number == 7))
        {
            answer.append("L");
            left_hand_position = number;
        }
        else if((number == 3) || (number == 6) || (number == 9))
        {
            answer.append("R");
            right_hand_position = number;
        }
        else
        {
            auto left = calc(left_hand_position, number);
            auto right = calc(right_hand_position, number);
            if(left < right)
            {
                answer.append("L");
                left_hand_position = number;
            }
            else if(left > right)
            {
                answer.append("R");
                right_hand_position = number;
            }
            else
            {
                if(hand.compare("right") == 0)
                {
                    answer.append("R");
                    right_hand_position = number;
                }
                else
                {
                    answer.append("L");
                    left_hand_position = number;
                }
            }
        }
    }
    return answer; 
}