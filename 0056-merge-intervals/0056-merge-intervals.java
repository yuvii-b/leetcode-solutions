class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length <= 1) return intervals;

        List<int[]> result = new ArrayList<>(); 
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for(int[] interval : intervals){
            if(result.isEmpty() || interval[0] > result.get(result.size() - 1)[1]){
                result.add(interval);
            }else{
                result.get(result.size() - 1)[1] = Math.max(interval[1], result.get(result.size() - 1)[1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}