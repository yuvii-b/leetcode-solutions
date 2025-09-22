class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int n : nums){
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        int count = 0;
        int max = Integer.MIN_VALUE;
        for(int f : freq.values()){
            max = Math.max(max, f);
        }
        for(int f : freq.values()){
            if(f == max) count += max;
        }
        return count;
    }
}