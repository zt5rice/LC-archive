class Solution2389 {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        List<Integer> ansa = new ArrayList<>();
        List<Integer> anss = new ArrayList<>();
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int sum = 0;
            anss.add(sum);
            ansa.add(ans[i]);
            while (ans[i] < nums.length && sum + nums[ans[i]] <= queries[i]) {
                sum += nums[ans[i]];      
                ans[i]++;
                anss.add(sum);
                ansa.add(ans[i]);
            }
        }
        // System.out.println("sum   :" + Arrays.toString(anss.toArray()));        
        // System.out.println("ans[i]:" + Arrays.toString(ansa.toArray()));

        return ans;
    }
}