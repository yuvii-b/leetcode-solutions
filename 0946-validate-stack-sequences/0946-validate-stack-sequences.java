class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> st = new ArrayDeque<>();
        int j = 0;
        for(int num : pushed){
            st.push(num);
            while(!st.isEmpty() && st.peek() == popped[j]){
                st.pop();
                ++j;
            }
        }
        return st.isEmpty();
    }
}