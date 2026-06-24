class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, area = 0;
        int[] nse = new int[n], pse = new int[n];
        Stack<Integer> st = new Stack<>();
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
