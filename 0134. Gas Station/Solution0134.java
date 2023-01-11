class Solution0134 { 
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curgas = 0;
        int totgas = 0, totcost = 0;
        int cand = 0;
        for (int i = 0; i < gas.length; i++) {
            curgas += gas[i];
            curgas -= cost[i];
            if (curgas < 0) {
                curgas = 0;
                cand = i+1;
            }
            totgas += gas[i];
            totcost += cost[i];
        }
        if (totgas < totcost) {
            return -1;
        }
        return cand;
    }
}