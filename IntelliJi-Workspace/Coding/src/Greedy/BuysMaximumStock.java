package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuysMaximumStock {
    public static int buyMaximumProducts(int n, int remainingAmount, int[] price) {
        // code here
        List<int[]> stocks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            stocks.add(new int[]{price[i], i + 1});
        }
        Collections.sort(stocks, (a, b) -> a[0] - b[0]);
        int result = 0;
        for (int i = 0; i < stocks.size(); i++) {
            int perDayAllStockValue = stocks.get(i)[0] * stocks.get(i)[1];
            if (perDayAllStockValue <= remainingAmount) {
                result += stocks.get(i)[1];
                remainingAmount -= perDayAllStockValue;
            } else if (stocks.get(i)[0] <= remainingAmount) {
                while (stocks.get(i)[0] <= remainingAmount) {
                    result++;
                    remainingAmount -= stocks.get(i)[0];
                }
            }
        }
        return result;
    }

    public int maxProfit(int[] prices) {
        List<int[]> stocks = new ArrayList<>();
        for (int i = 0; i < prices.length; i++) {
            stocks.add(new int[]{prices[i], i + 1});
        }
        int result=0;
        Collections.sort(stocks,(a,b)->a[0]-b[0]);
        for(int i=0;i<stocks.size();i++){
            if(stocks.get(i)[1]<stocks.getLast()[1] && stocks.get(i)[0]-stocks.getLast()[0]>0){
                result=Math.max(result,stocks.get(i)[0]-stocks.getLast()[0]);
            }
        }
        return result;
    }
}
