/**
 * @param {number[]} tasks
 * @return {number}
 */
var minimumRounds = function(tasks) {
    let count = new Map();
    for (let i = 0; i < tasks.length; i++) {
        // count.set(tasks[i], count[tasks[i]] != undefined ? count[tasks[i]] + 1 : 1); // xxxxxxxxxxxx
        // count.set(tasks[i], (count[tasks[i]] !== undefined ? (count.get(tasks[i]) + 1) : 1)); // xxxxxxxxxxxx
           count.set(tasks[i], (count.get(tasks[i]) !== undefined ? (count.get(tasks[i]) + 1) : 1));
    }
    let res = 0;
    const iterator = count.values();
    for (const value of iterator) {
        if (value < 2) {
            return -1;
        }
        res += parseInt((value + 2) / 3); // !!!  parseInt()
    }
    return res;
};

let tasks = [2,2,3,3,2,4,4,4,4,4];
let res = minimumRounds(tasks)
console.log(res);