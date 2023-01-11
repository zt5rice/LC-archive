var subArrayRanges = function(nums) {
    const flips = nums.map(num => -num);
    return -sumSubarrayMins(flips) - sumSubarrayMins(nums);
};

const sumSubarrayMins = function(arr) {
    let res = 0;
    
    const n = arr.length;
    const stack = [];
    
    for (let i = 0; i <= n; i++) {
        while (stack.length > 0 && arr[stack[stack.length - 1]] > (i === n ? -Infinity : arr[i])) {
            const j = stack.pop();
            const k = stack.length ? stack[stack.length - 1] : -1;
            res += arr[j] * (i - j) * (j - k);
        }
        stack.push(i);
    }
    
    return res;
};
