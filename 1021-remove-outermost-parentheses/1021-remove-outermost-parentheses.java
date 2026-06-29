class Solution {
    public String removeOuterParentheses(String s) {
        int depth = 0;
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch == '(' && depth++ > 0) sb.append(ch);
            if(ch == ')' && depth-- > 1) sb.append(ch);
        }
        return sb.toString();
    }
}