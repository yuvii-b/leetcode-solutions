class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int n = cost.length, total = 0, count = 0;
        for(int i = n - 1; i >= 0; --i){
            ++count;
            if(count % 3 != 0) total += cost[i];
        }
        return total;
    }
}