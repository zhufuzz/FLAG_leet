package ch9.Array;

// version 2: easier to understand but more code
class Ch9_54_Spiral_Matrix2 {
    public static int DOWN = 0;
    public static int RIGHT = 1;
    public static int LEFT = 2;
    public static int UP = 3;
    
    private static int[] dx = new int[]{1, 0, 0, -1};
    private static int[] dy = new int[]{0, 1, -1, 0};

    public static int turnRight(int direction) {
        if (direction == DOWN) {
            return LEFT;
        } else if (direction == RIGHT) {
            return DOWN;
        } else if (direction == LEFT) {
            return UP;
        } else if (direction == UP) {
            return RIGHT;
        }
        return -1;
    }
    
    public static int[] move(int[] cursor, int direction) {
        int[] nextCursor = new int[2];
        nextCursor[0] = cursor[0] + dx[direction];
        nextCursor[1] = cursor[1] + dy[direction];
        return nextCursor;
    }
}