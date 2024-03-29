package com.java2novice.ds.stack;
/*Towers of Hanoi implementation using stack.

The Tower of Hanoi is a mathematical game or puzzle. 
It consists of three rods, and a number of disks of different
 sizes which can slide onto any rod. The puzzle starts with the 
 disks in a neat stack in ascending order of size on one rod, 
 the smallest at the top, thus making a conical shape. 
 The objective of the puzzle is to move the entire stack to another rod,
  obeying the following rules:

1) Only one disk must be moved at a time.

2) Each move consists of taking the upper disk from one of the rods and 
sliding it onto another rod, on top of the other disks that may already 
be present on that rod.

3) No disk may be placed on top of a smaller disk.

In this example, we are solving it by using stacks
*/
public class _7TowersOfHanoiImpl {
    
    private static _2MyDynamicStack[] tower;
     
    public static void towersOfHanoi(int n) {
 
        // create three stacks, tower[0] is scratch
        tower = new _2MyDynamicStack[4];
        for (int i = 0; i <= 3; i++){
            tower[i] = new _2MyDynamicStack(4);
        }
        for (int d = n; d > 0; d--){
            // initialize
            // add disk d to tower 1
            tower[1].push(new Integer(d));
        }
        // move n disks from tower 1 to 2 using 3 as
        // intermediate tower
        showTowerStates(n, 1, 2, 3);
    }
 
    public static void showTowerStates(int n, int x, int y, int z) {
         
        if (n > 0) {
            try{
                showTowerStates(n - 1, x, z, y);
                // move d from top of tower x
                Integer d = (Integer) tower[x].pop();
                // to top of tower y
                tower[y].push(d);
                System.out.println("Move disk " + d
                        + " from tower "+ x + " to top of tower " + y);
                showTowerStates(n - 1, z, y, x);
            } catch(Exception ex){}
        }
    }
 
    public static void main(String[] args) {
        System.out.println("Running 3 disk problem:");
        towersOfHanoi(3);
    }
}
 
class MyDynamicStack_3 {
 
    private int stackSize;
    private int[] stackArr;
    private int top;
 
    /**
     * constructor to create stack with size
     * @param size
     */
    public MyDynamicStack_3(int size) {
        this.stackSize = size;
        this.stackArr = new int[stackSize];
        this.top = -1;
    }
 
    /**
     * This method adds new entry to the top
     * of the stack
     * @param entry
     * @throws Exception
     */
    public void push(int entry){
        if(this.isStackFull()){
            System.out.println(("Stack is full. Increasing the capacity."));
            this.increaseStackCapacity();
        }
        this.stackArr[++top] = entry;
    }
 
    /**
     * This method removes an entry from the
     * top of the stack.
     * @return
     * @throws Exception
     */
    public int pop() throws Exception {
        if(this.isStackEmpty()){
            throw new Exception("Stack is empty. Can not remove element.");
        }
        int entry = this.stackArr[top--];
        return entry;
    }
     
    /**
     * This method returns top of the stack
     * without removing it.
     * @return
     */
    public long peek() {
        return stackArr[top];
    }
 
    private void increaseStackCapacity(){
         
        int[] newStack = new int[this.stackSize*2];
        for(int i=0;i<stackSize;i++){
            newStack[i] = this.stackArr[i];
        }
        this.stackArr = newStack;
        this.stackSize = this.stackSize*2;
    }
     
    /**
     * This method returns true if the stack is
     * empty
     * @return
     */
    public boolean isStackEmpty() {
        return (top == -1);
    }
 
    /**
     * This method returns true if the stack is full
     * @return
     */
    public boolean isStackFull() {
        return (top == stackSize - 1);
    }
 
    public static void main(String[] args) {
        MyDynamicStack_3 stack = new MyDynamicStack_3(2);
        for(int i=1;i<10;i++){
            stack.push(i);
        }
        for(int i=1;i<4;i++){
            try {
                stack.pop();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
