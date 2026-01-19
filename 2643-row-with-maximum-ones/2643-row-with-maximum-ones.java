class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int maxCount = 0, index = 0;
        for(int i = 0; i < n; ++i){
            int countOnes = 0;
            for(int j = 0; j < m; ++j){
                countOnes += mat[i][j];
            }
            if(countOnes > maxCount){
                maxCount = countOnes;
                index = i;
            }
        }
        return new int[] {index, maxCount};
    }   
}