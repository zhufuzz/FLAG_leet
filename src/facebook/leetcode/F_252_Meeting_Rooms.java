package facebook.leetcode;
//Sort
import java.util.*;
/*Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

For example, Given [[0, 30],[5, 10],[15, 20]], return false.*/

//http://blog.csdn.net/sbitswc/article/details/49068503

class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
 }
 
public class F_252_Meeting_Rooms {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                int r = o1.start - o2.start;
                return r==0? o1.end - o2.end : r;
            }
        });
        for(int i=1;i<intervals.length;i++) {
            Interval t1 = intervals[i-1];
            Interval t2 = intervals[i];
            if(t1.end>t2.start) return false;
        }
        return true;
    }
}