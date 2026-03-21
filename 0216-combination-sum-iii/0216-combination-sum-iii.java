class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        solve(1, new ArrayList<>(), k, n, result);
        return result;
    }

    private void solve(int start, List<Integer> curr, int k, int sum, List<List<Integer>> result){
        if(curr.size() == k && sum == 0){
            result.add(new ArrayList<>(curr));
            return;
        }
        if(curr.size() > k || sum < 0) return;
        for(int i = start; i <= 9; i++){
            curr.add(i);
            solve(i + 1, curr, k, sum - i, result);
            curr.remove(curr.size() - 1);
        }
    }
}