class Solution {
    // tip: dont use stack, just use stringbuilder
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if(k == n) return "0";
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < n; ++i){
            char digit = num.charAt(i);
            while(!st.isEmpty() && k > 0 && st.peek() > digit) {
                st.pop();
                --k;
            }
            st.push(digit);
        }
        while(!st.isEmpty() && k > 0){
            st.pop();
            --k;
        }
        if(st.isEmpty()) return "0";
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) sb.append(st.pop());
        while(sb.length() > 0 && sb.charAt(sb.length() - 1) == '0') sb.deleteCharAt(sb.length() - 1);
        if(sb.length() == 0) return "0";
        return sb.reverse().toString();
    }
}