class Solution0787:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        dp = [float('inf')] * n
        dp[src] = 0
        for i in range(k+1):
            prev = dp.copy()
            for flight in flights:
                dp[flight[1]] = min(dp[flight[1]], prev[flight[0]] + flight[2])
        return dp[dst] if dp[dst] != float('inf') else -1
