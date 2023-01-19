/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var subarraysDivByK = function(nums, k) {
    let remArr = new Array(k).fill(0);
    remArr[0] = 1;
    let count = 0, curSum = 0, curRem = 0;
    for (let i = 0; i < nums.length; i++) {
        curSum += nums[i];
        curRem = curSum % k;
        if (curRem < 0) {
            curRem += k;
        }
        count += remArr[curRem];
        remArr[curRem]++;
    }
    return count;
};

var nums = [4,5,0,-2,-3,1];
var k = 5
var res = subarraysDivByK(nums, k);
console.log(res);