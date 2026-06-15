class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] check = new boolean[3];
        for(int[] triplet : triplets){
            if(triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]){
                check[0] |= (triplet[0] == target[0]);
                check[1] |= (triplet[1] == target[1]);
                check[2] |= (triplet[2] == target[2]);
            }
            if(check[0] && check[1] && check[2]) return true;
        }
        return check[0] && check[1] && check[2];
    }
}