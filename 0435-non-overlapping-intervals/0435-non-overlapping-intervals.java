class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> {
            if(a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        int limit = intervals[0][1], countToErase = 0;
        for(int i = 1; i < n; ++i){
            if(intervals[i][0] < limit) ++countToErase;
            else limit = intervals[i][1];
        }
        return countToErase;
    }
}