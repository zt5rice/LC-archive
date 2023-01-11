/**
 * @param {number} n
 * @return {number}
 */
 var climbStairs = function(n) {
    if (n < 3) return n;
    let pp = 1;
    let p = 1;
    let tmp = 2;
    for (let i = 2; i <= n; i++) {
        tmp = pp + p;
        pp = p;
        p = tmp;
    }
    return tmp;
};