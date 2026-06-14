class Solution {
    public boolean checkValidString(String s) {
        int minLeft = 0, maxLeft = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                ++minLeft;
                ++maxLeft;
            }else if(c == ')'){
                --minLeft;
                --maxLeft;
            }else{
                --minLeft;
                ++maxLeft;
            }
            if(maxLeft < 0) return false;
            if(minLeft < 0) minLeft = 0;
        }
        return (minLeft == 0);
    }
}