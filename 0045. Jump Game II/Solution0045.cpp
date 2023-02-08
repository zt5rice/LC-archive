class Solution0045 {
public:
    int jump(vector<int>& nums) {
        int steps = 0, farest = 0, cur = 0;
        for (int i = 0; i < nums.size()-1; i++) {
            farest = max(farest, i + nums[i]);
            if (farest >= nums.size() - 1) {
                return steps+1;
            }
            if (i == cur) {
                steps++;
                cur = farest;
            }
        }
        return steps;
    }
};