class Solution {
    public int strStr(String haystack, String needle) {
        // for(int i = 0; ; ++i){
        //     for(int j = 0; ; ++j){
        //         if(j == needle.length()) return i;
        //         if(i + j == haystack.length()) return -1;
        //         if(needle.charAt(j) != haystack.charAt(i + j)) break;
        //     }
        // }
        for(int i = 0, j = needle.length(); j<=haystack.length(); i++,j++){
            if(haystack.substring(i,j).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}