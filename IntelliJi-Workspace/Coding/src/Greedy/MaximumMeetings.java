package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumMeetings {
    class meetings
    {
        int start;
        int end;
        int pos;

        public meetings(int start, int end, int pos) {
            this.start=start;
            this.end=end;
            this.pos=pos;
        }
    }
    List<Integer> maximumMeetings(int starts[],int end[]){
        List<meetings> meet = new ArrayList<>();
        for(int i=0;i<starts.length;i++){
            meet.add(new meetings(starts[i],end[i],i+1));
        }
        List<Integer> Result= new ArrayList<>();
        Collections.sort(meet,(a,b)->a.end-b.end);
        int endtime=meet.get(0).end;
        Result.add(meet.get(0).pos);
        for(int i=1;i<meet.size();i++){
            int st=meet.get(i).start;
            if(st > endtime){
                endtime=meet.get(i).end;
                Result.add(meet.get(i).pos);
            }
        }
        return Result;


    }
}
