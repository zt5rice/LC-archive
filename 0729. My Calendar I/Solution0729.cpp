// https://leetcode.com/problems/my-calendar-i/discuss/266976/C%2B%2B-O(NLogN)-using-map-upper-bound
class MyCalendar {
public:
    map<int,int>events;
    MyCalendar() {   
    }
    bool book(int start, int end) {
        auto next = events.upper_bound(start);
        if(next != events.end() &&   (*next).second < end)return false;
        events.insert({end,start});
        return true;
    }
};