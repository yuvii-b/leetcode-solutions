class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int[] count = new int[26];
        StringBuilder half = new StringBuilder(n / 2), ans = new StringBuilder(n);
        for(int i = 0; i < n / 2; ++i){
            ++count[s.charAt(i) - 'a'];
        }
        for(int i = 0; i < 26; ++i){
            while(count[i]-- > 0) half.append((char)(i + 'a'));
        }
        ans.append(half);
        if((n & 1) == 1) ans.append(s.charAt(n / 2));
        ans.append(new StringBuilder(half).reverse());
        return ans.toString();
    }
}