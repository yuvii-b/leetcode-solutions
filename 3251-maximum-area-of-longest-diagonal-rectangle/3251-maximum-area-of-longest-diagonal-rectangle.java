class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int n = dimensions.length;
        int mArea = 0, mDiag = 0;
        for(int i = 0; i < n; ++i){
            int l = dimensions[i][0];
            int w = dimensions[i][1];
            int curr = l * l + w * w;
            if(curr > mDiag || (curr == mDiag && l * w > mArea)){
                mDiag = curr;
                mArea = l * w;
            }
        }
        return mArea;
    }
}