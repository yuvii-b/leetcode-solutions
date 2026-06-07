class Solution {
    // nums[a] + nums[b] == nums[d] - nums[c]
    public int countQuadruplets(int[] nums) {
        int count = 0, n = nums.length;
        Map<Integer, Integer> seen = new HashMap<>();
        for(int b = n - 3; b >= 1; --b){
            int c = b + 1;
            for(int d = c + 1; d < n; ++d){
                int diff = nums[d] - nums[c];
                seen.put(diff, seen.getOrDefault(diff, 0) + 1);
            }
            for(int a = b - 1; a >= 0; --a){
                int sum = nums[a] + nums[b];
                count += seen.getOrDefault(sum, 0);
            }
        }
        return count;
    }
}