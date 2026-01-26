class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length, mini = Integer.MAX_VALUE;
        for(int i = 0; i < n - 1; ++i){
            mini = Math.min(mini, arr[i + 1] - arr[i]);
        }
        for(int i = 0; i < n - 1; ++i){
            if(arr[i + 1] - arr[i] == mini){
                ans.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }
        return ans;
    }
}