class Solution {
    // TC - O(n), SC - O(1) (hashmap solution)
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), l = 0, r = 0, len = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(r < n){
            char ch = s.charAt(r);
            if(map.containsKey(ch)){
                l = Math.max(map.get(ch) + 1, l);
            }
            map.put(ch, r);
            len = Math.max(len, r - l + 1);
            ++r;
        }
        return len;
    }
}