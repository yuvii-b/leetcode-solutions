class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int l = 0, r = tokens.length - 1, score = 0, maxScore = 0;
        Arrays.sort(tokens);
        while(l <= r){
            if(power >= tokens[l]){
                power -= tokens[l];
                ++score;
                ++l;
                maxScore = Math.max(score, maxScore);
            }else if(score > 0 && l < r){
                power += tokens[r];
                --r;
                --score;
            }
            else break;
        }
        return maxScore;
    }
}