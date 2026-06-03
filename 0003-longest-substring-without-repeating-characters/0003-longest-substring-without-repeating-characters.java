class Solution {
    // TC - O(n), SC - O(1) (usage of set leads to slow shrink of window, use hashmap or index array)
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), l = 0, r = 0, len = 0;
        Set<Character> set = new HashSet<>();
        while(r < n){
            char ch = s.charAt(r);
            if(!set.contains(ch)){
                set.add(ch);
                len = Math.max(len, r - l + 1);
                ++r;
            }else{
                set.remove(s.charAt(l));
                ++l;
            }
        }
        return len;
    }
}