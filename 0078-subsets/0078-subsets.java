class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generate(0, new ArrayList<>(), result, nums);
        return result;
    }

    private void generate(int index, List<Integer> curr, List<List<Integer>> result, int[] nums){
        result.add(new ArrayList<>(curr));
        for(int i = index; i < nums.length; ++i){
            curr.add(nums[i]);
            generate(i + 1, curr, result, nums);
            curr.remove(curr.size() - 1);
        }
    }
}