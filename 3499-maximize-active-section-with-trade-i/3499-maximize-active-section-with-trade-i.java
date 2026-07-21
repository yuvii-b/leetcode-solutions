class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length(), i = 0, ones = 0;
        for(char ch : s.toCharArray()){
            if(ch == '1') ++ones;
        } 
        int ans = ones;
        while(i < n && s.charAt(i) == '1') ++i;
        int leftZero = 0;
        while(i < n && s.charAt(i) == '0'){
            ++leftZero;
            ++i;
        }
        while(i < n){
            int middleOne = 0;
            while(i < n && s.charAt(i) == '1'){
                ++middleOne;
                ++i;
            }
            if(i == n || middleOne == 0) break;
            int rightZero = 0;
            while(i < n && s.charAt(i) == '0'){
                ++rightZero;
                ++i;
            }
            ans = Math.max(ans, leftZero + ones + rightZero);
            leftZero = rightZero;
        }
        return ans;
    }
}