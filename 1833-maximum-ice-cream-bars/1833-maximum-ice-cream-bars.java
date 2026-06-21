class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int max = 0;
        for (int cost : costs) {
            max = Math.max(max, cost);
        }
        int[] count = new int[max + 1];
        for (int cost : costs) {
            ++count[cost];
        }
        int iceCreamCount = 0;        
        for (int price = 1; price <= max; price++) {
            if (count[price] == 0) continue;
            if (coins < price) break;
            int quantityToBuy = Math.min(count[price], coins / price);
            iceCreamCount += quantityToBuy;
            coins -= quantityToBuy * price;
        }
        return iceCreamCount;
    }
}