class Solution
{
public:
    int smallestDistancePair(vector<int> &nums, int k)
    {

        vector<int> nums = {6, 9, 1};
        int k = 2;
        sort(nums.begin(), nums.end());
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;
        for (int i = 0; i < nums.size() - 1; i++)
        {
            pq.push({nums[i + 1] - nums[i], i, i + 1});
        }
        vector<int> tmp;
        vector<int> res;
        while (k > 0)
        {
            tmp = pq.top();
            pq.pop();
            res.push_back(tmp[0]);
            if (res[2] + 1 < nums.size())
            {
                pq.push({nums[res[2] + 1] - nums[res[1]], res[1], res[2] + 1});
            }
            k--;
        }
        for (auto c : res)
            cout << c << endl;
        return res;
    }
};