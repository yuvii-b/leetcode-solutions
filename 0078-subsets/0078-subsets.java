class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generate(0, new ArrayList<>(), result, nums);
        return result;
    }

    private void generate(int index, List<Integer> curr, List<List<Integer>> result, int[] nums){
        if(index == nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[index]);
        generate(index + 1, curr, result, nums);
        curr.remove(curr.size() - 1);
        generate(index + 1, curr, result, nums);
    }
}