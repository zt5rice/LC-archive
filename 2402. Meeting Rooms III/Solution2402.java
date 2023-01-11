public class Solution2402 {
    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<Integer> ready = new PriorityQueue<>();
        for (int i = 0; i < n; i++) ready.offer(i);
        PriorityQueue<int[]> rooms = new PriorityQueue<>(
            (i1, i2) -> (i1[0] != i2[0]) ? (i1[0] - i2[0]) : (i1[1] - i2[1])
        );
        int[] res = new int[n];
        Arrays.sort(meetings,
                   (i1, i2) -> (i1[0] != i2[0]) ? (i1[0] - i2[0]) : (i1[1] - i2[1])
                   );
        int maxRoom = -1, maxFreq = 0;
        for (int[] meeting : meetings) {
            int s = meeting[0], e = meeting[1], r = -1;
            while (!rooms.isEmpty() && rooms.peek()[0] <= s) {
                int[] tmp = rooms.poll();
                int t = tmp[0];
                r = tmp[1];
                ready.add(r);
            }
            if (!ready.isEmpty()) {
                r = ready.poll();
                rooms.add(new int[]{e, r});
            } else {
                int[] tmp = rooms.poll();
                int t = tmp[0];
                r = tmp[1];
                rooms.add(new int[]{t+e-s, r});
            }
            res[r]++;
            if (res[r] > maxFreq) {maxRoom = r;maxFreq= res[r];} else if (res[r] == maxFreq && r < maxRoom) {maxRoom = r;}
            // System.out.println(Arrays.toString(res)+","+maxRoom);
        }
        
        return maxRoom;
    }    
}
