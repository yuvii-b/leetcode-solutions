class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> lst = new ArrayList<>();
        for(int x : nums1){
            map.put(x, 1);
        } 
        for(int x : nums2){
            if(map.containsKey(x) && map.get(x) == 1){
                lst.add(x);
                map.put(x, 0);
            }
        }
        return lst.stream().mapToInt(i->i).toArray();
    }
}