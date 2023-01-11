class Solution2440 { // 23-40
    int[] nums;
    public int componentValue(int[] nums, int[][] edges) {
        int n = nums.length;
        this.nums = nums;
        List<Integer>[] graph = new List[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
            sum += nums[i];
        }
        for (int[] e : edges) {
            int x = e[0], y = e[1];
            graph[x].add(y);
            graph[y].add(x);
        }
        int res = 0;
        for (int i = n; i >= 1; i--) { // i - num of seg
            if (sum % i != 0) continue;
            int ans = dfs(graph, sum/i, 0, -1);
            if (ans == 0) return i-1;
        }
        return 0;
    }
    
    private int dfs(List<Integer>[] graph, int target, int cur, int prev) {
        // base case
        if((graph[cur].size() == 1) && (graph[cur].get(0) == prev)) {
            if (nums[cur] > target) return -1;
            if (nums[cur] == target) return 0;
            return nums[cur]; 
        }
        int cursum = nums[cur];
        for (int nei : graph[cur]) {
            if (nei == prev) continue;
            int tmp = dfs(graph, target, nei, cur);
            if (tmp == -1) return -1;
            cursum += tmp;
        }
        if (cursum > target) return -1;
        if (cursum == target) return 0;
        return cursum;
    }
}
// https://leetcode.com/problems/create-components-with-same-value/discuss/2707267/Easy-Java-Solution

class Solution2440_bfs {
    //from https://leetcode.com/problems/create-components-with-same-value/discuss/2707217/BFS
    
    public int componentValue(int[] nums, int[][] edges) {
        
        List<List<Integer>> al = new ArrayList<>(nums.length);
        int[] degree = new int[nums.length];
        int sum = 0 ;
        
        for(int i = 0 ; i < nums.length; i++) {
            al.add(new ArrayList<>());
            sum += nums[i];
        }
        
        for(int[] e : edges) {
            degree[e[0]]++;
            degree[e[1]]++;
            al.get(e[0]).add(e[1]);
            al.get(e[1]).add(e[0]);
        }
        
        // Original solution runs from nums.length - 1 and would have handled the case in start. 
       // I have removed the check and chose to write generic solution , even if its not optimised.
        for(int i = nums.length ; i > 1; i--) {
            if(sum % i != 0 ) {
                continue;
            }
            
            
            if(bfs(sum/i, nums.clone(), degree.clone(), al)) {
                // edges to be deleted == number of partition - 1
                return i-1;
            }
            
        }
        
        return 0;
    }
    
    
    private boolean bfs(int target, int[] nums, int[] degree, List<List<Integer>> al) {
        
        Deque<Integer> q = new ArrayDeque<>();
        
        for(int i = 0 ; i < degree.length ; i++) {
            // Indicates leaf node.
            if(degree[i] == 1) {
                q.addLast(i);
            }
        }
        
        while(!q.isEmpty()) {
            
            int curr = q.removeFirst();
            
            for(int next : al.get(curr)) {
                
                if(nums[curr] > target)  {
                    return false;
                }
                
                nums[next] += nums[curr] < target ? nums[curr] : 0;
                
                degree[next]--;
                
                if(degree[next] == 1) {
                    q.addLast(next);
                }
                
            }
             
        }
        
        return true;
    }
}
// https://leetcode.com/problems/create-components-with-same-value/discuss/2707217/BFS