class Solution2398 {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int left = 0, n = chargeTimes.length;
        long sum = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int right = 0; right < n; right++) {
            sum += runningCosts[right];
            while (!deque.isEmpty() && chargeTimes[deque.peekLast()] <= chargeTimes[right]) {
                deque.pollLast();
            }
            deque.offerLast(right);
            if (chargeTimes[deque.peekFirst()] + (right - left + 1) * sum > budget) {
                if (deque.peekFirst() == left) {
                    deque.pollFirst();   
                }
                sum -= runningCosts[left++]; // !!!
            }
        }
        return n - left;
    }
}