class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> rev = new HashMap<>();

    for(int i = 0; i < s.length(); i++){
        char c1 = s.charAt(i);
        char c2 = t.charAt(i);

        if(map.containsKey(c1) && map.get(c1) != c2) return false;
        if(rev.containsKey(c2) && rev.get(c2) != c1) return false;

        map.put(c1, c2);
        rev.put(c2, c1);
    }
    return true;
    }
}