class Solution0219 {
public:
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        set<int> numset;
        for (int i = 0; i < nums.size(); i++) {
            if (numset.find(nums[i]) != numset.end()) {
                return true;
            }
            numset.insert(nums[i]);
            if (numset.size() > k) {
                numset.erase(nums[i-k]);
            }
        }
        return false;
    }
};