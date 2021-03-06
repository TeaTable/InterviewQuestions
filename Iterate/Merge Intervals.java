/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals,
            new Comparator<Interval>() {
                public int compare(Interval i1, Interval i2) {
                    if (i1.start != i2.start) {
                        return i1.start - i2.start;
                    }
                    else return i1.end - i2.end;
                }});
        List<Interval> merged = new ArrayList<Interval>();
        Interval last = null;
        for (Interval i : intervals) {
            if (last != null && last.end >= i.start) {
                last.end = Math.max(last.end, i.end);
            }
            else {
                last = i;
                merged.add(i);
            }
        }
        return merged;
    }
}
