package Greedy;

import java.util.*;

public class Mazimumtrain {
    static class Train{
        int arrival;
        int departure;
        int platform;
        Train(int arrival, int departure,int platform){
            this.arrival=arrival;
            this.departure=departure;
            this.platform=platform;
        }
    }
    public static int maximumtrain(Train trains[],int n){
        Arrays.sort(trains,Comparator.comparingInt(train->train.departure));

        Map<Integer, PriorityQueue<Integer>> platform= new HashMap<>();
        for(int i=1;i<=n;i++){
            platform.put(i,new PriorityQueue());
        }
        int maxTrains=0;
        for(Train train:trains){
            PriorityQueue<Integer> platformQueue= platform.get(train.platform);
            if(platformQueue.isEmpty() || platformQueue.peek()<=train.arrival){
                platformQueue.poll();
                platformQueue.add(train.departure);
                platform.put(train.platform,platformQueue);
                maxTrains++;
            }
        }
    return maxTrains;
    }

    public static void main(String args[]){
        Train train[]=new Train[6];
        train[0]=new Train(1000,1030,1);
        train[1]=new Train(1010,1030,1);
        train[2]=new Train(1000,1020,2);
        train[3]=new Train(1030,1230,2);
        train[4]=new Train(1200,1230,3);
        train[5]=new Train(900,1005,1);
        System.out.println(maximumtrain(train,6));

    }
}
