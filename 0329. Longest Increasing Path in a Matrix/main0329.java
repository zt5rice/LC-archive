import java.util.Arrays;

public class main0329 {
    public static void main(String[] args) {
        Solution0329 sol = new Solution0329();
        int[][] matrix;
        int longest;
        
        matrix = new int[][]{{9,9,4},{6,6,8},{2,1,1}};
        longest = sol.longestIncreasingPath(matrix);
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(longest);
    }
}

class Solution0329 { // tc/sc: o(row * col)
    int[][] DIRS = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public int longestIncreasingPath(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        int[][] dp = new int[r][c]; // max length starting from r,c
        for (int[] dpp : dp) {
            Arrays.fill(dpp,1);
           // System.out.println(Arrays.toString(dpp));
        }
        int longest = 1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                longest = Math.max(longest, dfs(i, j, matrix, dp));
            }
        }
        // for (int[] dpp : dp) {
        //     //Arrays.fill(dpp,1);
        //     System.out.println(Arrays.toString(dpp));
        // }        
        return longest;
    }
    
    private int dfs(int r, int c, int[][] matrix, int[][] dp) {
        int row = matrix.length, col = matrix[0].length;
        if (dp[r][c] != 1) {
            return dp[r][c];
        }
        //int maxLen = 1;
        for(int[] dir : DIRS) {
            int nxtr = r + dir[0];
            int nxtc = c + dir[1];
            if (nxtr >= 0 && nxtr < row && nxtc >= 0 && nxtc < col && matrix[nxtr][nxtc] > matrix[r][c]) {
               dp[r][c] = Math.max(dp[r][c], dfs(nxtr, nxtc, matrix, dp)+1); 
            }
        }
        return dp[r][c];
    }
}

class Solution0329_topo { 
    int[][] DIRS = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int longestIncreasingPath(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        int[][] count = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int[] dir : DIRS) {
                    if (compare(matrix, r, c, i, j, i+dir[0], j+dir[1], false)) {
                        count[i][j]++;
                    }
                }
            }
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (count[i][j] == 0) queue.offerLast(i*c+j);
            }
        }
        // for (int i = 0; i < r; i++) {
        //     System.out.println(Arrays.toString(count[i]));
        // }
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int tmp = queue.pollFirst();
                int curr = tmp/c, curc = tmp%c;
                for (int[] dir : DIRS) {
                    int nextr = curr + dir[0], nextc = curc + dir[1];
                    if (nextr < 0 || nextr >= r || nextc < 0 || nextc >= c || matrix[nextr][nextc] <= matrix[curr][curc]) continue;
                    if (--count[nextr][nextc] == 0) {
                        queue.offerLast(nextr*c + nextc);
                    }
                }
            }
            steps++;
        }
        return steps;
    }
    
    private boolean compare(int[][] matrix, int r, int c, int i, int j, int ni, int nj, boolean isIncr) {
        if (ni < 0 || ni >= r || nj < 0 || nj >= c) return false;
        if (isIncr && matrix[i][j] < matrix[ni][nj]) {
            return true;
        } else if (!isIncr && matrix[i][j] > matrix[ni][nj]) {
            return true;
        }
        return false;
    } 
}