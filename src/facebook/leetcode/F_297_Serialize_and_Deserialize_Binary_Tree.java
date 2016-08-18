package facebook.leetcode;
import java.util.Queue; //Tree, Design
/*297. Serialize and Deserialize Binary Tree My Submissions Question
Total Accepted: 13679 Total Submissions: 51133 Difficulty: Medium
Serialization is the process of converting a data structure or object into a sequence
 of bits so that it can be stored in a file or memory buffer, or transmitted across a
  network connection link to be reconstructed later in the same or another computer environment.
  
Design an algorithm to serialize and deserialize a binary tree. There is no restriction 
on how your serialization/deserialization algorithm should work. You just need to ensure
 that a binary tree can be serialized to a string and this string can be deserialized to
  the original tree structure.
  
For example, you may serialize the following tree
    1
   / \
  2   3
     / \
    4   5
as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. 
You do not necessarily need to follow this format, so please be creative and come up with 
different approaches yourself.
Note: Do not use class member/global/static variables to store states. 
Your serialize and deserialize algorithms should be stateless.*/
//http://shaowei-su.github.io/2015/12/05/leetcode297/

public class F_297_Serialize_and_Deserialize_Binary_Tree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }    
    public void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {sb.append("null,"); return;}
        sb.append(String.valueOf(node.val) + ",");
        buildString(node.left, sb);
        buildString(node.right, sb);
        return;
    }    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {return null;}
        Queue<String> queue = new LinkedList(Arrays.asList(data.split(",")));
        return buildTree(queue);
    }
    public TreeNode buildTree(Queue<String> queue) {
        String cur = queue.poll();
        if (cur.equals("null")) { return null; }
        TreeNode node = new TreeNode(Integer.valueOf(cur));
        node.left = buildTree(queue);
        node.right = buildTree(queue);
        return node;
    }
}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));