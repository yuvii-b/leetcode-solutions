class Solution {
    public String minWindow(String s, String t) {
        int n = s.length(), l = 0, r = 0, minLen = Integer.MAX_VALUE, start = -1;
        int[] hash = new int[256];
        for(char c : t.toCharArray()) hash[c]++;
        int count = 0;
        while(r < n){
            if(hash[s.charAt(r)] > 0) count++;
            hash[s.charAt(r)]--;
            while(count == t.length()){
                if(r - l + 1 < minLen){
                    minLen = r - l + 1;
                    start = l;
                }
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)] > 0) count--;
                l++;
            }
            r++;
        }
        return start == -1 ? "" : s.substring(start, start + minLen);
    }
}