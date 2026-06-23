class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int a : asteroids){
            if(a > 0) st.push(a);
            else{
                while(!st.isEmpty() && st.peek() > 0 && st.peek() < -a) st.pop();
                if(st.isEmpty() || st.peek() < 0) st.push(a);
                if(st.peek() == -a) st.pop();   
            }
        }
        int n = st.size(), i = n - 1;
        int[] res = new int[n];
        while(!st.isEmpty()) res[i--] = st.pop();
        return res;
    }
}