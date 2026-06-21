class Solution {
    // check the space optimized approach
    public int maxIceCream(int[] costs, int coins) {
        int[] sorted = countingSort(costs);
        int n = sorted.length, candies = 0, i = 0;
        while(i < n && coins > 0){
            if(coins >= sorted[i]){
                coins -= sorted[i++];
                ++candies;
            }else break;
        }
        return candies;
    }

    private int[] countingSort(int[] arr){
        int n = arr.length, max = arr[0];
        for(int i = 0; i < n; ++i){
            max = Math.max(max, arr[i]);
        }
        int[] count = new int[max + 1], output = new int[n];
        for(int i = 0; i < n; ++i){
            ++count[arr[i]];
        }
        for(int i = 1; i <= max; ++i){
            count[i] += count[i - 1];
        }
        for(int i = n - 1; i >= 0; --i){
            output[--count[arr[i]]] = arr[i];
        }
        return output;
    }
}