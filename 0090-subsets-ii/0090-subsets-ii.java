class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
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
        while(index + 1 < nums.length && nums[index] == nums[index + 1]) index++;
        generate(index + 1, curr, result, nums);
    }
}