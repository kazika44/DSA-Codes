package Greedy;

import java.util.*;

public class FindNoOfPlatform {
    static int findPlatform(int arr[], int dep[], int n) {
        // add your code here
        List<int[]> trains = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            trains.add(new int[]{arr[i], dep[i]});
        }
        Collections.sort(trains, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(trains.get(0));
        int ans = 1;
        for (int i = 1; i < trains.size(); i++) {
            int[] train = trains.get(i);
            int arrival = train[0];
            int departure = train[1];
            while (!pq.isEmpty() && pq.peek()[1] <= arrival) {
                pq.poll();
            }
            pq.add(train);
            ans = Math.max(ans, pq.size());
        }
        return ans;
    }
}
