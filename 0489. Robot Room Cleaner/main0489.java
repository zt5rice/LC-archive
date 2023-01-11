import java.util.*;

public class main0489 {
  

}

class Solution0489 { // 27 - 32 - 40
    int[][] DIRS = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    Set<String> visited;
    Robot robot;
    
    public void cleanRoom(Robot robot) {
        this.robot = robot;
        this.visited = new HashSet<>();
        dfs(0,0,0);
    }
    
    public void dfs(int r, int c, int d) {
        robot.clean();
        visited.add(r + "," + c);
        // generation
        for (int i = 0; i < 4; i++) {
            int newD = (d + i) % 4;
            int newR = r + DIRS[newD][0];
            int newC = c + DIRS[newD][1];
            if (!visited.contains(newR + "," + newC) && robot.move()) {
                dfs(newR, newC, newD);
                goBack();
            }
            robot.turnRight();
        }
    }
    
    public void goBack() {
        robot.turnRight();
        robot.turnRight();
        robot.move();        
        robot.turnRight();
        robot.turnRight();        
    }
}

// This is the robot's control interface.
// You should not implement it, or speculate about its implementation
interface Robot {
    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    public boolean move();

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    public void turnLeft();
    public void turnRight();

    // Clean the current cell.
    public void clean();
}
