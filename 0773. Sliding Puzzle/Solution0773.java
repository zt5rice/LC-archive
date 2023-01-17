// # modify solution to general size puzzle board
// # lintcode https://www.lintcode.com/problem/794/
// # leetcode https://leetcode.com/problems/sliding-puzzle/description/
public class Solution0773 {
    public int slidingPuzzle(int[][] board) {
        int row = board.length, col = board[0].length;
        String src = print(board), tgt = "123450";
        Deque<String> queue = new ArrayDeque<>();
        Set<String> visited =  new HashSet<>();
        Map<String, Integer> dist = new HashMap<>();
        queue.offerLast(src);
        dist.put(src, 0);

        while (!queue.isEmpty()) {
            String curt = queue.pollFirst();
            if (curt.equals(tgt)) {
                return dist.get(tgt);
            }
            for (String next : getNext(curt, board)) {
                if (dist.containsKey(next)) {
                    continue;
                }
                dist.put(next, dist.get(curt) + 1);
                queue.offerLast(next);
            }
        }
        return -1;
    }

    public static final int[][] DIRS = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

    private List<String> getNext(String curt, int[][] board) {
        List<String> nexts = new ArrayList<>();
        int row = board.length, col = board[0].length;
        int zeroIdx = curt.indexOf('0');
        int r = zeroIdx/col, c = zeroIdx%col;
        for (int[] dir : DIRS) {
            int r_ = r + dir[0], c_ = c + dir[1];
            if (r_ < 0 || r_ >= row || c_ < 0 || c_>= col) {
                continue;
            }
            String next = swap(curt, r*col+c, r_*col+c_);
            nexts.add(next);
        }
        return nexts;
    }

    private String print(int[][] board) {
        int row = board.length, col = board[0].length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sb.append((char) (board[i][j] + '0'));
            }
        }
        return sb.toString();
    }

    private String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }
}