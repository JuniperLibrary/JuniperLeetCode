package com.uin.leetcode_100.string.leetcode_1812;

/**
 * 1812. 判断国际象棋棋盘中一个格子的颜色
 * 给你一个坐标 coordinates ，它是一个字符串，表示国际象棋棋盘中一个格子的坐标。下图是国际象棋棋盘示意图。
 * 如果所给格子的颜色是白色，请你返回 true，如果是黑色，请返回 false 。
 * 给定坐标一定代表国际象棋棋盘上一个存在的格子。坐标第一个字符是字母，第二个字符是数字。
 * 示例 1：
 * <p>
 * 输入：coordinates = "a1"
 * 输出：false
 * 解释：如上图棋盘所示，"a1" 坐标的格子是黑色的，所以返回 false 。
 * 示例 2：
 * <p>
 * 输入：coordinates = "h3"
 * 输出：true
 * 解释：如上图棋盘所示，"h3" 坐标的格子是白色的，所以返回 true 。
 * 示例 3：
 * <p>
 * 输入：coordinates = "c7"
 * 输出：false
 * 提示：
 * coordinates.length == 2
 * 'a' <= coordinates[0] <= 'h'
 * '1' <= coordinates[1] <= '8'
 */
public class Main {
    /**
     * @param coordinates
     * @return 白色返回true，黑色返回false
     */
    public boolean squareIsWhite(String coordinates) {
//        char[][] map = new char[][]{
//                {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'},
//                {'1', '2', '3', '4', '5', '6', '7', '8'}
//        };

        char x = coordinates.charAt(0);
        int letter = (x - 'a') % 2;
        char y = coordinates.charAt(1);
        int number = (y - '1' + 1) % 2;

        // y =  x 全是黑颜色
        // y = -x 全是白色

        //拆分出列、行的颜色
        // 白色 用0表示
        // 黑色 用1 表示

        return (letter ^ number) == 0;
    }

    public boolean helper(String coordinates) {
        return (coordinates.charAt(0) + coordinates.charAt(1)) % 2 == 1;
    }
}
