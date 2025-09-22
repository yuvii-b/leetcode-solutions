class Solution {
    public int maxFrequencyElements(int[] nums) {
        byte[] freq = new byte[101];
        byte max = 0, count = 0;
        for(int n : nums){
            byte f = ++freq[n];
            if(f > max){
                max = f;
                count = f;
            } else if (f == max){
                count += f;
            }
        }
        return count;
    }
}