public class Solution0499 {
    String[] HASH = new String[]{"d","l","r","u"};
    int[] deltaX = new int[]{1,0,0,-1};
    int[] deltaY = new int[]{0,-1,1,0};
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        if (ball.length == 0 || hole.length == 0 || maze.length == 0 || maze[0].length == 0) {
            return "impossible";
        }
        int row = maze.length, col = maze[0].length;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offerLast(ball[0] * col + ball[1]);
        Map<Integer, Pair> distance = new HashMap<>();
        distance.put(ball[0] * col + ball[1], new Pair(0, ""));

        while (!queue.isEmpty()) {
            int curr = queue.pollFirst();
            int curx = curr / col, cury = curr % col;
            Pair curPair = distance.get(curr);
            for (int i = 0; i < 4; i++) {
                int next = kickBall(curx, cury, i, maze, hole[0], hole[1]);
                int nextX = next / col, nextY = next % col;
                int nextDist = curPair.dist + Math.abs(nextX - curx) + Math.abs(nextY - cury);
                String nextPath = curPair.path + HASH[i];
                if (distance.containsKey(next) && distance.get(next).lessThanOrEqual(new Pair(nextDist, nextPath))) {
                    continue;
                }
                queue.offerLast(next);
                distance.put(next, new Pair(nextDist, nextPath));
            }
        }

        if (distance.containsKey(hole[0] * col + hole[1])) {
            return distance.get(hole[0] * col + hole[1]).path;
        }

        return "impossible";
    }

    
    int kickBall(int x, int y, int dir, int[][] maze, int holeX, int holeY) {
        int row = maze.length, col = maze[0].length;
        int dx = deltaX[dir], dy = deltaY[dir];
        while ((x != holeX || y != holeY) && !isWall(x, y, maze)) {
            x += dx;
            y += dy;
        }
        if (x == holeX && y == holeY) {
            return x * col + y;
        }
        return (x - dx) * col + (y - dy); // stop position
    }

    boolean isWall(int x, int y, int[][] maze) {
        if (!(0 <= x && x < maze.length && 0 <= y && y < maze[0].length)) {
            return true;
        }
        return maze[x][y] == MazeGridType.WALL;
    }

    class MazeGridType {
        static int SPACE = 0;
        static int WALL = 1;
    }

    class Pair {
        int dist;
        String path;
        public Pair(int dist, String path) {
            this.dist = dist;
            this.path = path;
        }
        public boolean lessThanOrEqual(Pair p) {
            if (this.dist != p.dist) {
                return this.dist < p.dist;
            }
            return this.path.compareTo(p.path) <= 0;
        }
    }
}
