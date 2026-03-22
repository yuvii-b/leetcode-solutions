class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        generate(0, new ArrayList<>(), s, result);
        return result;
    }

    private void generate(int index, List<String> curr, String s, List<List<String>> res){
        if(index == s.length()){    
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i = index; i < s.length(); ++i){
            if(isPalindrome(s, index, i)){
                curr.add(s.substring(index, i + 1));
                generate(i + 1, curr, s, res);
                curr.remove(curr.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}