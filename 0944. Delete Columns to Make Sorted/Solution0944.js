/**
 * @param {string[]} strs
 * @return {number}
 */
var minDeletionSize = function(strs) {
    let row = strs.length, col = strs[0].length;
    let res = 0;
    for (let i = 0; i < col; i++) {
        for (let j = 1; j < row; j++) {
            if (strs[j][i] < strs[j-1][i]) {
                res++;
                break;
            }
        }
    }
    return res;     
};

var strs = ["cba","daf","ghi"];
var res = minDeletionSize(strs);
console.log(res)