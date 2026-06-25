class Solution {
    public String decodeString(String s) {
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();
        StringBuilder curr = new StringBuilder();
        int n = 0;
        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)) n = n * 10 + (ch - '0');
            else if(ch == '['){
                numStack.push(n);
                stringStack.push(curr);
                curr = new StringBuilder();
                n = 0;
            }else if(ch == ']'){
                int multiplier = numStack.pop();
                StringBuilder decoded = stringStack.pop();
                for(int i = 0; i < multiplier; ++i){
                    decoded.append(curr);
                }
                curr = decoded;
            }else curr.append(ch);
        }
        return curr.toString();
    }
}