class Solution1631 { 
    public int minimumEffortPath(int[][] heights) {
        int[][] DIRS = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int row = heights.length, col = heights[0].length, INF = Integer.MAX_VALUE;
        int[][] minEff = new int[row][col];
        for (int[] mineff : minEff) {
            Arrays.fill(mineff, INF);
        }
        boolean[][] visited = new boolean[row][col];
        PriorityQueue<Cell> minheap = new PriorityQueue<>((c1, c2) -> c1.diff - c2.diff);
        // 1. init
        minEff[0][0] = 0;
        //visited[0][0] = true;
        minheap.add(new Cell(0,0,0));
        while (!minheap.isEmpty()) {
            Cell cur = minheap.poll();
            int curr = cur.r, curc = cur.c, curd = cur.diff;
            visited[curr][curc] = true;
            if (curr == row - 1 && curc == col - 1) {
                return curd;
            }
            for (int[] dir : DIRS) {
                int nr = curr + dir[0], nc = curc + dir[1];
                if (!isValid(nr, nc, row, col) || visited[nr][nc]) {
                    continue;
                }
                int nd = Math.abs(heights[nr][nc] - heights[curr][curc]);
                int maxdiff = Math.max(nd, curd);
                if (maxdiff < minEff[nr][nc]) {
                    minEff[nr][nc] = maxdiff;
                    minheap.add(new Cell(nr, nc, maxdiff));
                }
            }
        }
        return minEff[row-1][col-1];
    }
    
    private boolean isValid(int r, int c, int row, int col) {
        if (r < 0 || r >= row || c < 0 || c >= col) {
            return false;
        }
        return true;
    }
}

class Cell {
    int r, c, diff;
    public Cell(int r, int c, int diff) {
        this.r = r;
        this.c = c;
        this.diff = diff;
    }
}