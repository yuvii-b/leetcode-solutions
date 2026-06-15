class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for(int card : hand){
            map.put(card, map.getOrDefault(card, 0 ) + 1);
        }
        Arrays.sort(hand);
        for(int card : hand){
            if(map.get(card) == 0) continue;
            for(int i = 0; i < groupSize; ++i){
                int nextCard = card + i;
                if(map.getOrDefault(nextCard, 0) <= 0) return false;
                map.put(nextCard, map.get(nextCard) - 1);
            }
        }
        return true;
    }
}