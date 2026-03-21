class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] freq = new boolean[nums.length];
        generate(nums, new ArrayList<>(), freq, result);
        return result;
    }

    private void generate(int[] nums, List<Integer> curr, boolean[] freq, List<List<Integer>> result){
        if(curr.size() == nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i = 0; i < nums.length; ++i){
            if(freq[i]) continue;
            if(i > 0 && nums[i] == nums[i - 1] && !freq[i - 1]) continue;
            curr.add(nums[i]);
            freq[i] = true;
            generate(nums, curr, freq, result);
            curr.remove(curr.size() - 1);
            freq[i] = false;
        }
    }
}