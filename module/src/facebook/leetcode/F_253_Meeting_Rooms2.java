package facebook.leetcode;
//Heap, Greedy, Sort
import java.util.*;

/*Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
For example, Given [[0, 30],[5, 10],[15, 20]], return 2.*/

//http://leetcode0.blogspot.com/2015/12/253-meeting-rooms-ii.html

class Interval {
  int start;int end;
  Interval() { start = 0; end = 0; }
  Interval(int s, int e) { start = s; end = e; }
 }
 
public class F_253_Meeting_Rooms2 {
    public int minMeetingRooms(Interval[] intervals) {
      Arrays.sort(intervals,new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                if(a.start > b.start)
                    return 1;
                else if(a.start < b.start)
                    return -1;
                else
                    return a.end - b.end;
            } 
        });
        List<Interval> list = new LinkedList<Interval>();
        for(int i =0;i<intervals.length;i++){
            list.add(intervals[i]);
        }
        int res = 0;
        while(list.isEmpty()==false){
            int right = -1;
            res++;
            // arrange the max conference on this table
            for(int i =0;i<list.size();i++){
                if(right<= list.get(i).start){
                    right = list.remove(i).end;
                    i--;
                }
            }
        }
        return res;
    }
}