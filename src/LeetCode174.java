public class LeetCode174 {
    public static void main(String[] args) {
        int[][] dungeon = {{1, -3, 3}, {0, -2, 0}, {-3, -3, -3}};
//        int[][] dungeon = {{100}};

//        int area = dungeon[0].length * dungeon.length;
        int[][] result = new int[dungeon.length][dungeon[0].length];
//        int[][] life = new int[dungeon.length][dungeon[0].length];
        for (int i = dungeon.length - 1; i >= 0; --i) {
            for (int j = dungeon[0].length - 1; j >= 0; --j) {
                if (i == dungeon.length - 1 && j == dungeon[0].length - 1) {
                    result[i][j] = dungeon[i][j] > 0 ? 1 : -dungeon[i][j] + 1;
//                    life[0][0] = dungeon[0][0];
                } else if (i == dungeon.length - 1) {
//                    life[i][j] = life[i][j - 1] + dungeon[i][j];
                    result[i][j] = Math.max(result[i][j + 1] - dungeon[i][j], 1);
                } else if (j == dungeon[0].length - 1) {
//                    life[i][j] = life[i - 1][j] + dungeon[i][j];
                    result[i][j] = Math.max(result[i + 1][j] - dungeon[i][j], 1);
                } else {
                    result[i][j] = Math.max(Math.min(result[i + 1][j], result[i][j + 1]) - dungeon[i][j], 1);
                }
            }
        }
        System.out.println(result[0][0]);
    }
}
