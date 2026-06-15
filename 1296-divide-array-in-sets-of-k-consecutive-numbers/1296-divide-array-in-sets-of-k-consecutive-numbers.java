class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length % k != 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Arrays.sort(nums);
        for(int num : nums){
            if(map.get(num) == 0) continue;
            for(int i = 0; i < k; ++i){
                int nextNum = num + i;
                if(map.getOrDefault(nextNum, 0) <= 0) return false;
                map.put(nextNum, map.get(nextNum) - 1);
            }
        }
        return true;
    }
}