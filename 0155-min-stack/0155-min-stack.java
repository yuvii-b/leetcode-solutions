// space: O(n)
class MinStack {

    private Stack<Long> st;
    long minimum;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int value) {
        if(st.isEmpty()){
            st.push((long)value);
            minimum = value;
            return;
        }
        if(value > minimum) st.push((long)value);
        else{
            st.push(2L * value - minimum);
            minimum = value;
        }
    }
    
    public void pop() {
        if(st.isEmpty()) return;
        long x = st.pop();
        if(x < minimum){
            minimum = 2 * minimum - x;
        }
    }
    
    public int top() {
        if(st.isEmpty()) return -1;
        long x = st.peek();
        if(x < minimum) return (int)minimum;
        return (int)x;
    }
    
    public int getMin() {
        return (int)minimum;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */