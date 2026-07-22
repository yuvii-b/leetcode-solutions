class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nge = new HashMap<>();
        Deque<Integer> st = new ArrayDeque<>();
        int n = nums2.length;
        for(int i = n - 1; i >= 0; --i){
            while(!st.isEmpty() && st.peek() <= nums2[i]) st.pop();
            nge.put(nums2[i], (st.isEmpty() ? -1 : st.peek()));
            st.push(nums2[i]);
        }
        n = nums1.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; ++i){
            ans[i] = nge.get(nums1[i]);
        }
        return ans;
    }
}