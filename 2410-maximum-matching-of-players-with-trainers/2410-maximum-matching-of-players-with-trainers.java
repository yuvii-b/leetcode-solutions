class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int n = players.length, m = trainers.length, x = 0, y = 0;
        Arrays.sort(players);
        Arrays.sort(trainers);
        while(x < n && y < m){
            if(trainers[y] >= players[x]){
                ++x;   
            }
            ++y; 
        }
        return x;
    }
}