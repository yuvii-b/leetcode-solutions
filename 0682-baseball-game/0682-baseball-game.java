class Solution {
    public int calPoints(String[] operations) {
        int totalScore = 0;
        Deque<Integer> st = new ArrayDeque<>();
        for(String op : operations){
            if(op.equals("+")){
                int top = st.pop();
                int score = top + st.peek();
                st.push(top);
                st.push(score); 
            }else if(op.equals("D")){
                st.push(2 * st.peek());
            }else if(op.equals("C")) st.pop();
            else st.push(Integer.parseInt(op));
        }
        while(!st.isEmpty()) totalScore += st.pop();
        return totalScore;
    }
}