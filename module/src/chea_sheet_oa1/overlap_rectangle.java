package chea_sheet_oa1;

public class overlap_rectangle {
  //rectangle A, B
  //time O(1), space O(1)
  public static boolean check(Node topLeftA, Node topLeftB, Node  bottomRightA, Node bottomRightB) {
      //if one rectangle is on left side of other
      if (bottomRightA.y <= topLeftB.y || bottomRightB.y <= topLeftA.y) {
          return false;
      }
      //if one rectangle is above other
      if (topLeftA.x >= bottomRightB.x || topLeftB.x >= bottomRightA.x) {
        return false;
      }
      return true;
    }
  
  public static class Node {
    double x;
    double y;
    public Node(double x, double y) {
      this.x = x;
      this.y = y;
    }
  }
}
