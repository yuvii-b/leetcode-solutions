class Solution {
    // 2 pointer solution
    public int longestValidParentheses(String s) {
        int n = s.length(), left = 0, right = 0, maxLen = 0;
        for(int i = 0; i < n; ++i){
            char ch = s.charAt(i);
            if(ch == '(') ++left;
            else ++right;
            if(left == right) maxLen = Math.max(maxLen, 2 * left);
            else if(right > left) {
                left = 0;
                right = 0;
            }
        }
        left = 0; right = 0;
        for(int i = n - 1; i >= 0; --i){
            char ch = s.charAt(i);
            if(ch == '(') ++left;
            else ++right;
            if(left == right) maxLen = Math.max(maxLen, 2 * right);
            else if(left > right){
                left = 0;
                right = 0;
            }
        }
        return maxLen;
    }
}