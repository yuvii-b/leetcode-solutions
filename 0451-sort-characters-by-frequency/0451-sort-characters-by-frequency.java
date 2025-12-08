class Solution {
    public String frequencySort(String s) {
        if(s == null || s.length() == 0) return s;
        Map<Character, Integer> freq = new HashMap<>();
        for(char c : s.toCharArray()){
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        int maxFreq = 0;
        for(int f : freq.values()){
            maxFreq = Math.max(f, maxFreq);
        }
        List<Character>[] buckets = new List[maxFreq + 1];
        for(int i = 1; i <= maxFreq; ++i){
            buckets[i] = new ArrayList<>();
        }
        for(Map.Entry<Character, Integer> it : freq.entrySet()){
            char c = it.getKey();
            int f = it.getValue();
            buckets[f].add(c);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = maxFreq; i >= 1; --i){
            for(char c : buckets[i]){
                for(int k = 0; k < i; ++k) sb.append(c);
            }
        }
        return sb.toString();
    }
}