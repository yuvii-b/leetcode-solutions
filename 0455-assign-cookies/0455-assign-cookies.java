class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length, m = s.length, x = 0, y = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(x < n && y < m){
            if(s[y] >= g[x]){
                ++x;   
            }
            ++y; 
        }
        return x;
    }
}