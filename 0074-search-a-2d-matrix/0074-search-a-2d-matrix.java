class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int start = 0, end = rows * cols - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            int midElement = matrix[mid / cols][mid % cols];
            if(midElement == target) return true;
            else if(midElement > target) end = mid - 1;
            else start = mid + 1;
        }
        return false;
    }
}