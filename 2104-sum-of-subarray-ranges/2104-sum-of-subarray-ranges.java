class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        return subarrayMax(nums, n) - subarrayMin(nums, n);
    }

    private long subarrayMax(int[] nums, int n){
        int[] nge = new int[n], pgee = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n - 1; i >= 0; --i){
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]) st.pop();
            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        st.clear();
        for(int i = 0; i < n; ++i){
            while(!st.isEmpty() && nums[st.peek()] < nums[i]) st.pop();
            pgee[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        long sum = 0;
        for(int i = 0; i < n; ++i){
            long left = i - pgee[i], right = nge[i] - i;
            sum += left * right * nums[i];
        }
        return sum;
    }

    private long subarrayMin(int[] nums, int n){
        int[] nse = new int[n], psee = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n - 1; i >= 0; --i){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) st.pop();
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        st.clear();
        for(int i = 0; i < n; ++i){
            while(!st.isEmpty() && nums[st.peek()] > nums[i]) st.pop();
            psee[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        long sum = 0;
        for(int i = 0; i < n; ++i){
            long left = i - psee[i], right = nse[i] - i;
            sum += left * right * nums[i];
        }
        return sum;
    }
}