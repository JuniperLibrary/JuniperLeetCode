package com.uin.didi.didi17.a3;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

/**
 * 滴滴出行2017秋招笔试真题-编程题汇总--地下迷宫
 * 小青蛙有一天不小心落入了一个地下迷宫,小青蛙希望用自己仅剩的体力值P跳出这个地下迷宫。为了让问题简单,假设这是一个n*m的格子迷宫,迷宫每个位置为0或者1,0代表这个位置有障碍物,小青蛙达到不了这个位置;1代表小青蛙可以达到的位置。
 * 小青蛙初始在(0,0)位置,地下迷宫的出口在(0,m-1)(保证这两个位置都是1,并且保证一定有起点到终点可达的路径),小青蛙在迷宫中水平移动一个单位距离需要消耗1点体力值,向上爬一个单位距离需要消耗3个单位的体力值,
 * 向下移动不消耗体力值,当小青蛙的体力值等于0的时候还没有到达出口,小青蛙将无法逃离迷宫。
 * <p>
 * 现在需要你帮助小青蛙计算出能否用仅剩的体力值跳出迷宫(即达到(0,m-1)位置)。
 * 输入包括n+1行:
 * 第一行为三个整数n,m(3 <= m,n <= 10),P(1 <= P <= 100)
 * 接下来的n行:
 * 每行m个0或者1,以空格分隔
 * <p>
 * 如果能逃离迷宫,则输出一行体力消耗最小的路径,输出格式见样例所示;如果不能逃离迷宫,则输出"Can not escape!"。 测试数据保证答案唯一
 * <p>
 * 4 4 10 1 0 0 1 1 1 0 1 0 1 1 1 0 0 1 1
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int P = in.nextInt();
            int[][] a = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = in.nextInt();
                }
            }
            boolean[][] flag = new boolean[n][m];
            ArrayList<Integer> path = new ArrayList<>();

            if (isTruePath(0, 0, P, a, path, flag)) {
                for (int i = 0; i < path.size() - 2; i += 2)
                    System.out.print("[" + path.get(i) + "," + path.get(i + 1) + "]" + ",");
                System.out.println("[" + path.get(path.size() - 2) + "," + path.get(path.size() - 1) + "]");
            } else {
                System.out.println("Can not escape!");
            }
        }
    }

    private static boolean isTruePath(int i, int j, int P, int[][] a, ArrayList<Integer> path, boolean[][] flag) {
        if (i < 0 || i >= a.length || j < 0 || j >= a[0].length || P < 0 || a[i][j] == 0 || flag[i][j] == true) {
            return true;
        }
        flag[i][j] = true;
        path.add(i);
        path.add(j);
        if (i == 0 && j == a[0].length - 1) {
            return true;
        }

        if (isTruePath(i, j - 1, P - 1, a, path, flag) ||
                isTruePath(i, j + 1, P - 1, a, path, flag) ||
                isTruePath(i - 1, j, P - 3, a, path, flag) ||
                isTruePath(i + 1, j, P, a, path, flag)) {
            return true;
        }
        path.remove(path.size() - 1);
        path.remove(path.size() - 1);
        return false;
    }

}
/**
package 校招真题2017;
        import java.util.PriorityQueue;
        import java.util.Scanner;
        import java.util.Stack;
public class 地下迷宫2 {
    public static void Main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int m=scan.nextInt();
        int p=scan.nextInt();
        int[][] map=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map[i][j]=scan.nextInt();
            }
        }
        boolean[][] seen=new boolean[n][m];
        PriorityQueue queue=new PriorityQueue();
        queue.add(new Node(0,0,0,null));
        while(!queue.isEmpty()){
            Node tmp=queue.poll();
            int row=tmp.row;
            int col=tmp.col;
            if(seen[row][col]){
                continue;
            }else{
                seen[row][col]=true;
            }
            if(row==0&&col==m-1){
                if(tmp.step>p){
                    System.out.println("Can not escape!");
                    return;
                }
                Node current=tmp;
                Stack stack=new Stack();
                while(current!=null){
                    stack.add(current);
                    current=current.prev;
                }
                while(stack.size()!=1){
                    Node nn=stack.pop();
                    System.out.print("["+nn.row+","+nn.col+"],");
                }
                Node nn=stack.pop();
                System.out.print("["+nn.row+","+nn.col+"]");
            }
            //down
            if(row+1<n&&map[row+1][col]==1){
                queue.add(new Node(row+1,col,tmp.step,tmp));
            }
            //up
            if(row-1>=0&&map[row-1][col]==1){
                queue.add(new Node(row-1,col,tmp.step+3,tmp));
            }
            if(col+1<m&&map[row][col+1]==1){
                queue.add(new Node(row,col+1,tmp.step+1,tmp));
            }
            if(col-1>=0&&map[row][col-1]==1){
                queue.add(new Node(row,col-1,tmp.step+1,tmp));
            }
        }
    }
    public static class Node implements Comparable{
        int row;
        int col;
        int step;
        Node prev;
        public Node(int row, int col, int step,Node prev) {
            this.row = row;
            this.col = col;
            this.step = step;
            this.prev=prev;
        }
        public int compareTo(Node o) {
            if(this.step>o.step){
                return 1;
            }else if(this.step<o.step){
                return -1;
            }else{
                return 0;
            }
        }
    }
}
*/
