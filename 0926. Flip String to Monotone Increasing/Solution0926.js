/**
 * @param {string} s
 * @return {number}
 */
var minFlipsMonoIncr = function(s) {
    let res = 0;
    let ones = 0;
    for (let i = 0; i < s.length; i++) {
        if (s.charAt(i) == '1') {
            ones++;
        } else {
            res = Math.min(res + 1, ones);
        }
    }
    return res;
};