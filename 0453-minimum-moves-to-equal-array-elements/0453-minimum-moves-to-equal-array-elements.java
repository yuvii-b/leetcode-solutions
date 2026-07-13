class Solution {
    public int minMoves(int[] nums) {
        int minimum = Integer.MAX_VALUE, moves = 0;
        for(int num : nums) minimum = Math.min(minimum, num);
        for(int num : nums) moves += (num - minimum);
        return moves;
    }
}