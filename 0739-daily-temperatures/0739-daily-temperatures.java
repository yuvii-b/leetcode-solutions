class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] nge = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for(int i = n - 1; i >= 0; --i){
            while(!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]) st.pop();
            nge[i] = st.isEmpty() ? 0 : st.peek() - i;
            st.push(i);
        }
        return nge;
    }
}