class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length(), l = 0, r = 0, count = 0;
        int[] charCount = new int[3];
        while(r < n){
            charCount[s.charAt(r) - 'a']++;
            while(charCount[0] > 0 && charCount[1] > 0 && charCount[2] > 0){
                count += n - r;
                charCount[s.charAt(l) - 'a']--;
                l++;
            }
            r++;
        }
        return count;
    }
}