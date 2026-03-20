class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        solve(0, new ArrayList<>(), target, candidates, result);
        return result;
    }

    private void solve(int i, List<Integer> curr, int target, int[] candidates, List<List<Integer>> result){
        if(target < 0) return;
        if(i == candidates.length){
            if(target == 0){
                result.add(new ArrayList<>(curr));
            }
            return;
        }
        curr.add(candidates[i]);
        solve(i, curr, target - candidates[i], candidates, result);
        curr.remove(curr.size() - 1);
        solve(i + 1, curr, target, candidates, result);
    }
}