class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int count = 0, maxEnd = 0;
        Arrays.sort(intervals, (a, b) -> (a[0] != b[0]) ? Integer.compare(a[0], b[0]) : Integer.compare(b[1], a[1]));
        for(int[] interval : intervals){
            if(interval[1] > maxEnd){
                maxEnd = interval[1];
                ++count;
            }
        }
        return count;
    }
}