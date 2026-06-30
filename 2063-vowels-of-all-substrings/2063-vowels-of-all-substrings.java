class Solution {
    public long countVowels(String word) {
        long count = 0, n = word.length();
        for(int i = 0; i < n; ++i){
            if("aeiou".indexOf(word.charAt(i)) >= 0){
                count += (n - i) * (i + 1);
            }
        }
        return count;
    }
}