class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastSeen = new int[26];
        for(int i = 0; i < s.length(); ++i){
            lastSeen[s.charAt(i) - 'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); ++i){
            end = Math.max(end, lastSeen[s.charAt(i) - 'a']);
            if(end == i){
                res.add(end - start + 1);
                start = i + 1;
            }
        }
        return res;
    }
}