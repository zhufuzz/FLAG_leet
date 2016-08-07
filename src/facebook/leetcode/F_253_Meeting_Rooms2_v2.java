package facebook.leetcode;
import java.util.*;//Java O(n) sweepline solution
//https://leetcode.com/discuss/88716/java-o-n-sweepline-solution
public class F_253_Meeting_Rooms2_v2 {
  public int minMeetingRooms(Interval[] intervals) {
      List<int[]> meet = new ArrayList<>();      
      for(Interval interval : intervals) {
          meet.add(new int[] {interval.start, 1});
          meet.add(new int[] {interval.end, 0});
      }      
      Collections.sort(meet, new Comparator<int[]> () {
          public int compare(int[] a, int[] b) {
              return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
          }
      });            
      int count = 0;
      int ans = 0;     
      
      for(int[] m : meet) {
          if(m[1] == 1) {
              count++;
          } else {
              count--;
          }
          ans = Math.max(ans, count);
      }      
      return ans;
  }
  
  //https://leetcode.com/discuss/86333/easy-and-concise-java-sol
  public int minMeetingRooms2(Interval[] intervals) {
    Arrays.sort(intervals, new Comparator<Interval>() {
        public i-nt compare(Interval in1, Interval in2) {
            return in2.end - in1.end;
        }
    });
    List<Interval> list = new LinkedList<>(Arrays.asList(intervals));
    int count = 0;
    while(!list.isEmpty()) {
        count++;
        Interval prev = null;
        Iterator<Interval> it = list.iterator();
        while(it.hasNext()) {
            Interval curr = it.next();
            if(prev == null || prev.start >= curr.end ) {
                it.remove();
                prev = curr;
            }
        }
    }
    return count;
  }
}