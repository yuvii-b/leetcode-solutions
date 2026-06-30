class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();
        for(String token : tokens){
            if(isOperator(token)){
                int val2 = st.pop();
                int val1 = st.pop();
                switch(token){
                    case "+" -> st.push(val1 + val2);
                    case "-" -> st.push(val1 - val2);
                    case "*" -> st.push(val1 * val2);
                    case "/" -> st.push(val1 / val2);
                }
            }else{
                st.push(Integer.parseInt(token));
            }
        }
        return st.pop();
    }

    private boolean isOperator(String s){
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}