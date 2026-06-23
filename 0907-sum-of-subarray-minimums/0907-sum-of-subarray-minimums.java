class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length, sum = 0, mod = (int)1e9 + 7;
        int[] nse = findNSE(arr, n); // next smaller element
        int[] psee = findPSEE(arr, n); // previous smaller or equal element
        for(int i = 0; i < n; ++i){
            int left = i - psee[i], right = nse[i] - i;
            long freq = (long) left * right;
            int val = (int)((freq * arr[i]) % mod);
            sum = (sum + val) % mod;
        }
        return sum;
    }

    private int[] findNSE(int[] arr, int n){
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n - 1; i >= 0; --i){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }

    private int[] findPSEE(int[] arr, int n){
        int[] psee = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; ++i){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]) st.pop();
            psee[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return psee;
    }
}