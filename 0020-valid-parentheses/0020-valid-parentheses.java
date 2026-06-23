class Solution {
    public boolean isValid(String str) {
        Stack<Character> st = new Stack<>();
        for(char ch : str.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '[') st.push(ch);
            else{
                if(st.isEmpty()) return false;
                char c = st.peek();
                if ((ch == ')' && c != '(') || (ch == '}' && c != '{') || (ch == ']' && c != '[')) return false;
                st.pop();
            }
        }
        return st.isEmpty();
    }
}