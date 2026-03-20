class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        solve(0, new ArrayList<>(), target, candidates, result);
        return result;
    }

    private void solve(int i, List<Integer> curr, int target, int[] candidates, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(curr));
            return;
        }
        if(target < 0 || i == candidates.length) return;
        curr.add(candidates[i]);
        solve(i + 1, curr, target - candidates[i], candidates, result);
        curr.remove(curr.size() - 1);
        while(i + 1 < candidates.length && candidates[i] == candidates[i + 1]) i++;
        solve(i + 1, curr, target, candidates, result);
    }
}