class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] targetFreq = new int[26], originalFreq = new int[26];
        int count = Integer.MAX_VALUE;
        for(char ch : target.toCharArray()) ++targetFreq[ch - 'a'];
        for(char ch : s.toCharArray()) ++originalFreq[ch - 'a'];
        for(char ch : target.toCharArray()){
            count = Math.min(count, originalFreq[ch - 'a'] / targetFreq[ch - 'a']);
        }
        return count;
    }
}