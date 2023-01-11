import java.util.*;

public class main0261 {
    public static void main(String[] args) {
        Solution0261 sol = new Solution0261();
        int edges[][], n;
        boolean res;
        
        n = 5;
        edges = new int[][]{{0,1},{0,2},{0,3},{1,4}};
        res = sol.validTree(n, edges);
        System.out.println(res);
    }
}
/* 
Variant of topological sort due to double directed edge

*/
class Solution0261 { // method: dfs; tc: o(n), sc: o(n)
    public boolean validTree(int n, int[][] edges) {
        if (edges.length + 1 != n) {
		    return false;
        }
        List[] graph = new List[n];
        buildGraph(n, edges, graph);
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                // dfs(visited, i, graph);
                bfs(visited, i, graph);
            }
        }
        return count == 1;
    }
    
    private void dfs(boolean[] visited, int idx, List[] graph) {
        visited[idx] = true;
        List<Integer> neis = graph[idx];
        if (neis == null) return;
        for (int nei : neis) {
            if (!visited[nei]) dfs(visited, nei, graph);
        }
    }
    
    private void bfs(boolean[] visited, int idx, List[] graph) {
        // visited[idx] = true;
        Deque<Integer> q = new ArrayDeque<>();  
        q.offerLast(idx);
        while (!q.isEmpty()) {
            int tmp = q.pollFirst();
            visited[tmp] = true;
            List<Integer> neis = graph[tmp];
            if (neis == null) continue;
            for (int nei : neis) {
                if (visited[nei] == true) continue;
                q.offerLast(nei);
            }
        }       
    }
    
    private void buildGraph(int n, int[][] edges, List[] graph) {
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int[] e : edges) {
            int x = e[0], y = e[1];
            graph[x].add(y);
            graph[y].add(x);
        }
        return;
    }
}