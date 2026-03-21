class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generate(0, nums, result);
        return result;
    }

    private void generate(int index, int[] nums, List<List<Integer>> result){
        if(index == nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int n : nums) temp.add(n);
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i = index; i < nums.length; ++i){
            swap(nums, i, index);
            generate(index + 1, nums, result);
            swap(nums, i, index);
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}