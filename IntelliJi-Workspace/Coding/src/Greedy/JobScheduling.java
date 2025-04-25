package Greedy;

import java.util.Arrays;

public class JobScheduling {
    //Function to find the maximum profit and the number of jobs done.
    class Job {
        int id, deadline, profit;

        Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    int[] JobScheduling(Job arr[], int n) {
        // Your code here
        Arrays.sort(arr, ((a, b) -> b.profit - a.profit));
        boolean result[] = new boolean[n];
        int countJob = 0;
        int totalProfit = 0;
        for (int i = 0; i < n; i++) {
            for (int j = Math.min(n - 1, arr[i].deadline); j > 0; j--) {
                if (result[i] == false) {
                    result[i] = true;
                    countJob++;
                    totalProfit += arr[i].profit;
                    break;
                }
            }
        }
        return new int[]{countJob, totalProfit};
    }
}
