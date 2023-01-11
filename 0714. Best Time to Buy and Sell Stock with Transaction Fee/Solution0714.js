/**
 * @param {number[]} prices
 * @param {number} fee
 * @return {number}
 */
var maxProfit = function(prices, fee) {
    let n = prices.length, buy = -prices[0], sell = 0;
    for (let i = 1; i < n; i++) {
        buy = Math.max(buy, sell - prices[i]);
        sell = Math.max(sell, buy + prices[i] - fee);
    }
    return sell;    
};
var prices = [1, 3, 2, 8, 4, 9];
console.log(prices);
var res = maxProfit(prices,2);
console.log(res);