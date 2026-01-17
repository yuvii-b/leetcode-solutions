class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length, low = 0, high = position[n - 1] - position[0];
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(check(position, mid, m)){
                low = mid + 1;
            }else high = mid - 1;
        }
        return high;
    }

    private boolean check(int[] position, int distance, int m){
        int n = position.length, balls = 1, last = position[0];
        for(int i = 1; i < n; ++i){
            if(position[i] - last >= distance){
                ++balls;
                last = position[i];
            }
            if(balls >= m) return true;
        }
        return false;
    }
}