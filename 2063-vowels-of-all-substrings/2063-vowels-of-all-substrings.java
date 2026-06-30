class Solution {
    public long countVowels(String word) {
        long count = 0;
        int n = word.length();
        for(int i = 0; i < n; ++i){
            if(isVowel(word.charAt(i))){
                count += (long)(n - i) * (long)(i + 1);
            }
        }
        return count;
    }

    private boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}