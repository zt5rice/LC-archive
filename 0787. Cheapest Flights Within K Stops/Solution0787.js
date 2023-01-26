/**
 * @param {number} n
 * @param {number[][]} flights
 * @param {number} src
 * @param {number} dst
 * @param {number} k
 * @return {number}
 */
var findCheapestPrice = function(n, flights, src, dst, k) {
    let M = Array(n).fill().map((_, i)=> i != src ? Infinity : 0);
    for (let i = 0; i < k + 1; i++) {
        let N = [...M]
        for (let [frm, to, price] of flights) {
            N[to] = Math.min(N[to], M[frm] + price);
        }
        M = [...N]
    }
    return M[dst] == Infinity ? -1 : M[dst];
};
// https://leetcode.com/problems/cheapest-flights-within-k-stops/solutions/684443/javascript-10-lines-of-sweet-bellman-ford/