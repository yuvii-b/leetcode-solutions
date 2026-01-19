class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int low = 0, high = m * n - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int midEle = matrix[mid / m][mid % m];
            if(midEle == target) return true;
            else if(midEle > target) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }
}