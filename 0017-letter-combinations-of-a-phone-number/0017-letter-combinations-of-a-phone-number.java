class Solution {
    private String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        solve(0, new StringBuilder(), digits, result);
        return result;
    }

    private void solve(int i, StringBuilder curr, String digits, List<String> result){
        if(i == digits.length()){
            result.add(curr.toString());
            return;
        }
        String letters = map[digits.charAt(i) - '0'];
        for(char c : letters.toCharArray()){
            curr.append(c);
            solve(i + 1, curr, digits, result);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}