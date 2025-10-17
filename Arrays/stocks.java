package Arrays;

public class stocks {
    public int maxProfit(int[] prices) {
        int hold = -prices[0];
        int notHold = 0;

        for (int i = 1; i < prices.length; i++) {
            notHold = Math.max(notHold, hold + prices[i]);
            hold = Math.max(hold, -prices[i]);
        }

        return notHold;
    }
}
