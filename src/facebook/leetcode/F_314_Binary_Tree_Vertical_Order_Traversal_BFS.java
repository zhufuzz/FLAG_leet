package facebook.leetcode;
import java.util.*;

//https://leetcode.com/discuss/79821/java-bfs-concise-code-using-2-maps
  
public class F_314_Binary_Tree_Vertical_Order_Traversal_BFS {
  public List<List<Integer>> verticalOrder(TreeNode root) {
    if (root == null)         return new ArrayList<List<Integer>>();
    
    Map<TreeNode, Integer> columnMap = new HashMap<TreeNode, Integer>();
    Map<Integer, List<Integer>> vertical = new TreeMap<Integer, List<Integer>>();
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    
    queue.offer(root);
    columnMap.put(root, 0);
    int col;
    
    while (!queue.isEmpty()) {
        root = queue.poll();
        col = columnMap.get(root);
        
        if (!vertical.containsKey(col)) {
            vertical.put(col, new ArrayList<Object>());
        }
        vertical.get(col).add(root.val);
        
        if (root.left != null) {
            columnMap.put(root.left, col - 1);
            queue.offer(root.left);
        }
        
        if (root.right != null) {
            columnMap.put(root.right, col + 1);
            queue.offer(root.right);
        }
    }
    
    return new ArrayList<List<Integer>>(vertical.values());
  }
}