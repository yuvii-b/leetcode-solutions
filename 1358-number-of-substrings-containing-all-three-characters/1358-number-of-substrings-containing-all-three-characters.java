class Solution {    
    public int numberOfSubstrings(String s) {
        int n = s.length(), count = 0;
        int[] lastSeen = {-1, -1, -1};
        for(int i = 0; i < n; ++i){
            lastSeen[s.charAt(i) - 'a'] = i;
            count += (1 + Math.min(Math.min(lastSeen[0], lastSeen[1]), lastSeen[2]));
        }
        return count;
    }
}