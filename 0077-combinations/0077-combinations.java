class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        solve(1, new ArrayList<>(), n, k, result);
        return result;
    }

    private void solve(int i, List<Integer> curr, int n, int k, List<List<Integer>> result){
        if(curr.size() == k){
            result.add(new ArrayList<>(curr));
            return;
        }
        if(i > n) return;
        if(curr.size() + (n - i + 1) < k) return; // prune early
        curr.add(i);
        solve(i + 1, curr, n, k, result);
        curr.remove(curr.size() - 1);
        solve(i + 1, curr, n, k, result);
    }
}