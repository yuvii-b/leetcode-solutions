class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        Map<Integer, Integer> ranks = new HashMap<>();
        int rank = 1;
        for(int num : sortedArr){
            if(!ranks.containsKey(num)) ranks.put(num, rank++);
        }
        for(int i = 0; i < arr.length; ++i){
            arr[i] = ranks.get(arr[i]);
        }
        return arr;
    }
}