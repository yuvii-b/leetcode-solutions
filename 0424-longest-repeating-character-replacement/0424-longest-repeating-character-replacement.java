class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length(), l = 0, r = 0, maxLen = 0, maxFreq = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(r < n){
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(ch));
            if((r - l + 1) - maxFreq > k){
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                ++l;
            }else maxLen = Math.max(maxLen, r - l + 1);
            ++r;
        }
        return maxLen;
    }
}