/**
 * @param {number[]} nums
 * @return {number}
 */
var jump = function(nums) {
    let steps = 0, cur = 0, longest = 0, len = nums.length;
    for (let i = 0; i < len-1; i++) {
        if (i > cur) return -1;
        longest = Math.max(longest, i + nums[i]);
        if (longest >= len - 1) return steps + 1;
        if (i == cur) {
            cur = longest; steps++;
        }
    }
    return steps;    
};