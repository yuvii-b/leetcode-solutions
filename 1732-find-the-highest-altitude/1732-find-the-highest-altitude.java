class Solution {
    public int largestAltitude(int[] gain) {
        int height = 0, maxHeight = 0;
        for(int num : gain){
            height += num;
            maxHeight = Math.max(height, maxHeight);
        }
        return maxHeight;
    }
}