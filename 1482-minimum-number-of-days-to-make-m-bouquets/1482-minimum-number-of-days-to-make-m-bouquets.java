class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        if((long)m * k > n) return -1;
        for(int day : bloomDay){
            min = Math.min(min, day);
            max = Math.max(max, day);
        }
        while(min <= max){
            int mid = min + (max - min) / 2; 
            if(possibleBoquets(bloomDay, mid, k) >= m){
                max = mid - 1;
            }else min = mid + 1;;
        }
        return min;
    }

    private int possibleBoquets(int[] bloomDay, int day, int k){
        int boquets = 0, flowers = 0;
        for(int val : bloomDay){
            if(val <= day) ++flowers;
            else flowers = 0;
            if(flowers == k){
                ++boquets;
                flowers = 0;
            }
        }
        return boquets;
    }
}