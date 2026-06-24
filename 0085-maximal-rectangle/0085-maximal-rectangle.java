class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length, area = 0;
        int[] heights = new int[m];
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                if(matrix[i][j] == '1') heights[j] += 1;
                else heights[j] = 0;
            }
            area = Math.max(area, largestRectangleArea(heights));
        }
        return area;
    }

    private int largestRectangleArea(int[] heights) {
        int n = heights.length, area = 0;
        int[] nse = new int[n], pse = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; --i) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i])
                st.pop();
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        st.clear();
        for (int i = 0; i < n; ++i) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i])
                st.pop();
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        for (int i = 0; i < n; ++i) {
            area = Math.max(area, heights[i] * (nse[i] - pse[i] - 1));
        }
        return area;
    }
}