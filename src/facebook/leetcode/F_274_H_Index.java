package facebook.leetcode;
//Hash Table, Sort
import java.util.Arrays;

/*Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N 鈭� h papers have no more than h citations each."

For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.

Note: If there are several possible values for h, the maximum one is taken as the h-index.

Hint:

An easy approach is to sort the array first.
What are the possible values of h-index?*/

//http://www.cnblogs.com/grandyang/p/4781203.html
/*这道题让我们求H指数，这个质数是用来衡量研究人员的学术水平的质数，定义为一个人的学术文章有n篇分别被引用了n次，那么H指数就是n。而且wiki上直接给出了算法，可以按照如下方法确定某人的H指数：1、将其发表的所有SCI论文按被引次数从高到低排序；2、从前往后查找排序后的列表，直到某篇论文的序号大于该论文被引次数。所得序号减一即为H指数。我也就没多想，直接按照上面的方法写出了代码：*/

//https://leetcode.com/discuss/88718/a-very-simple-solution-using-sort-in-java


public class F_274_H_Index {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length < 2) {
        return citations == null || citations.length == 0? 0: citations[0] == 0? 0: 1;
    	}
	    Arrays.sort(citations);
	    int index = 1;
	    while (index <= citations.length) {
	        if (citations[citations.length - index] >= index) {
	            index += 1;
	        } else {
	            break;
	        }
	    }
	    return index - 1;
    }
}