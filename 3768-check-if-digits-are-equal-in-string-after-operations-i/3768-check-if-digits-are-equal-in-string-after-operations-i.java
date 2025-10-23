class Solution {
    public boolean hasSameDigits(String s) {
        while(s.length() > 2){
            StringBuilder res = new StringBuilder();
            for(int i = 0; i + 1 < s.length(); ++i){
                res.append((s.charAt(i) - '0' + s.charAt(i + 1) - '0') % 10);
            }
            s = res.toString();
        }
        return s.charAt(0) == s.charAt(1);
    }
}