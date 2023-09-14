#include <string>
#include <vector>
#include <unordered_map>
#include <list>
#include <boost/algorithm/string.hpp>
using namespace std;

class LRUcache
{
public:
    LRUcache(int cacheSize)
    {
        maxSize = cacheSize;
    }
    int get(string city)
    {
        auto it = cache.find(city);
        if (it != cache.end()) // 캐시에 있다면 갱신 후 1 리턴
        {
            update(it->second);
            return 1;
        }
        else // 캐시에 없다면, 추가 후 -5 리턴
        {
            if (data.size() >= maxSize) // 캐시가 가득 찼을 때는 가장 오래된 데이터 삭제
            {
                cache.erase(data.back());
                data.pop_back();
            }
            data.push_front(city); // 추가
            cache[city] = data.begin();
            return 5;
        }
    }
private:
    int maxSize;
    list<string> data;
    unordered_map<string, list<string>::iterator> cache;
    
    void update(list<string>::iterator it)
    {
        data.splice(data.begin(), data, it);
    }
};

int solution(int cacheSize, vector<string> cities) {
    int answer = 0;
    LRUcache cache(cacheSize);
        
    if (!cacheSize)
        return cities.size() * 5;
        
    for (int i = 0; i < cities.size(); i++)
    {
        boost::algorithm::to_lower(cities[i]);
        answer += cache.get(cities[i]);
    }
        
    
    return answer;
}