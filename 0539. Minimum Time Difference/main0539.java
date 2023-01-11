import java.util.*;
public class main0539 {
    public static void main(String[] args) {
       Solution0539 sol = new Solution0539();
       List<String> timePoints;
       int res;

       timePoints = Arrays.asList("23:59","00:00");
        System.out.println(Arrays.toString(timePoints.toArray()));
        res = sol.findMinDifference(timePoints);
        System.out.println(res);
        System.out.println();

       timePoints = Arrays.asList("00:00","23:59","00:00");
       System.out.println(Arrays.toString(timePoints.toArray()));
       res = sol.findMinDifference(timePoints);
       System.out.println(res);
       System.out.println();

    }
}


class Solution0539 { // 57 - 04
    public int findMinDifference(List<String> timePoints) {
        int res = 24*60;
        int prev = -1;
        TreeSet<Integer> set = new TreeSet<>();
        for (String point : timePoints) {
            int curTime = calcTime(point);
            if (!set.add(curTime)) {
                return 0;
            }
        }
        
        for (int time : set) {
            System.out.println(time);
            if (prev >= 0) {
                res = Math.min(res, time - prev);
            } 
            prev = time;
        }
        
        res = Math.min(res, 24*60 - set.last() + set.first());
        return res;
    }
    
    private int calcTime(String point) {
        return Integer.parseInt(point.substring(0,2)) * 60 + Integer.parseInt(point.substring(3));
    }
}

class Solution0539 {  // tc:o(1)
    public int findMinDifference(List<String> timePoints) {
        boolean[] times = new boolean[24*60];
        int first = 24*60+1, last = -1;
        for (String timePoint : timePoints) {
            int curTime = convTime(timePoint);
            if (times[curTime]) {
                return 0;
            }
            times[curTime] = true;
            first = Math.min(first, curTime);
            last = Math.max(last, curTime);
        }
        int prev = -1, res = 24*60+1;
        for (int i = 0; i < 24*60; i++) {
            if (!times[i]) continue;
            if (prev == -1) {
                prev = i;
            } else {
                res = Math.min(res, i - prev);
                prev = i;
            }
        }
        res = Math.min(res, first + 24*60 - last);
        return res;
    }
    private int convTime(String time) {
        return Integer.parseInt(time.substring(0,2))*60+ Integer.parseInt(time.substring(3));
    }
}