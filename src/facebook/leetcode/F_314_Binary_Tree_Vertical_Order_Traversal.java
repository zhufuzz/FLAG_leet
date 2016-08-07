package facebook.leetcode;
//Hash Table
import java.util.*;

/*Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
If two nodes are in the same row and column, the order should be from left to right.
Examples: Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its vertical order traversal as:
[
  [9],
  [3,15],
  [20],
  [7]
]
Given binary tree [3,9,20,4,5,2,7],
    _3_
   /   \
  9    20
 / \   / \
4   5 2   7
return its vertical order traversal as:
[
  [4],
  [9],
  [3,5,2],
  [20],
  [7]
]
Show Company Tags
Show Tags
Show Similar Problems
*/
//http://www.cnblogs.com/yrbbest/p/5065457.html


/*��⣺

������Vertical order traversal���������˼�ܼ򵥵����Ӿٵò����ã���������ڶ���������5�����������Ļ����ͻ��20��һ��column��ܵ���˵���Ǽٶ�һ��node��column�� i����ô����������column����i - 1��������column����i + 1�����ǿ�����decoratorģʽ����һ��TreeColumnNode������һ��TreeNode���Լ�һ��column value��Ȼ����level order traversal���м���Ϳ����ˣ������ʱ����һ��HashMap����column value�Լ���ͬvalue�ĵ㡣ҲҪ����һ��min column value��һ��max column value����������մ�С����˳���ȡhashmap���ֵ�����

Time Complexity - O(n)��  Space Complexity - O(n)*/
public class F_314_Binary_Tree_Vertical_Order_Traversal {
    private class TreeColumnNode{
        public TreeNode treeNode;
        int col;
        public TreeColumnNode(TreeNode node, int col) {
            this.treeNode = node;
            this.col = col;
        }
    }
    
    public List<List<Integer>> verticalOrder(TreeNode root) {    
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Queue<TreeColumnNode> queue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        queue.offer(new TreeColumnNode(root, 0));
        int curLevel = 1;
        int nextLevel = 0;
        int min = 0;
        int max = 0;
        
        while(!queue.isEmpty()) {
            TreeColumnNode node = queue.poll();
            if(map.containsKey(node.col)) {
                map.get(node.col).add(node.treeNode.val);
            } else {
                map.put(node.col, new ArrayList<Integer>(Arrays.asList(node.treeNode.val)));
            }
            curLevel--;
            
            if(node.treeNode.left != null) {
                queue.offer(new TreeColumnNode(node.treeNode.left, node.col - 1));
                nextLevel++;
                min = Math.min(node.col - 1, min);
            }
            if(node.treeNode.right != null) {
                queue.offer(new TreeColumnNode(node.treeNode.right, node.col + 1));
                nextLevel++;
                max = Math.max(node.col + 1, max);
            }
            if(curLevel == 0) {
                curLevel = nextLevel;
                nextLevel = 0;
            }
        }
        
        for(int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        
        return res;
    }
}