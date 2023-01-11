class Solution1557 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> res = new ArrayList<>();
        int[] deg = new int[n];
        for(List<Integer> edge: edges) {
            deg[edge.get(1)]++;
        }
        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args)
        
    }
}