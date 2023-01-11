class Solution {
    public void buildReverseEdges(List<List<Integer>> nodeMap, int val) {
        for (int pairVal : nodeMap.get(val)) {
            if (pairVal != 0 && reverseEdges[pairVal] == -1) {
                reverseEdges[pairVal] = val;
                buildReverseEdges(nodeMap, pairVal);
            }
        }
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> nodeMap = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            nodeMap.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            nodeMap.get(edge[0]).add(edge[1]);
            nodeMap.get(edge[1]).add(edge[0]);
        }

        reverseEdges = new int[n];
        Arrays.fill(reverseEdges, -1);
        buildReverseEdges(nodeMap, 0);

        visited = new boolean[n];
        visited[0] = true;

        for (int i = 0; i < n; i++) {
            if (hasApple.get(i)) {
                dfsEdge(i);
            }
        }
        return ans * 2;
    }

    int ans = 0;
    int[] reverseEdges;
    boolean[] visited;

    public void dfsEdge(int to) {
        if (!visited[to]) {
            visited[to] = true;
            ans++;
            dfsEdge(reverseEdges[to]);
        }
    }
}

// 作者：geguanting
// 链接：https://leetcode.cn/problems/minimum-time-to-collect-all-apples-in-a-tree/solution/dfsshen-ru-qian-chu-by-geguanting/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。