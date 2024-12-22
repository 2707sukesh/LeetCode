
import java.util.Stack;

public class MaximumNumberOfMoves_2684 {
    static class Solution {
        class Pair{
            int row;
            int column;
            Pair(int row,int column){
                this.row = row;
                this.column = column;
            }
        }

        public boolean inRange(int row,int column,int[][] grid,int target){
            if(!(row > 0 && row < grid.length)) return false;
            else if(!(column > 0 && column < grid[0].length)) return false;
            else if(!(grid[row][column] > target)) return false;
            return true;
        }
        public int maxMoves(int[][] grid) {
            int maxDepth = 0;
            for(int i = 0 ; i < grid[0].length ; i++){
                Stack<Pair> queue = new Stack<>();
                queue.add(new Pair(0,i));
                int currentDepth = 0;
                while(!queue.isEmpty()){
                    Pair pair = queue.pop();
                    boolean isPossible = false;
                    if(inRange(pair.row - 1 ,pair.column + 1,grid,grid[pair.row][pair.column])){
                        isPossible = true;
                        queue.add(new Pair(pair.row - 1 ,pair.column + 1));
                    }
                    if(inRange(pair.row,pair.column+1,grid,grid[pair.row][pair.column])){
                        isPossible = true;
                        queue.add(new Pair(pair.row,pair.column+1));
                    }
                    if(inRange(pair.row + 1,pair.column + 1,grid,grid[pair.row][pair.column])){
                            isPossible = true;
                        queue.add(new Pair(pair.row+1,pair.column+1));
                    }
                    if(isPossible){
                        currentDepth ++;
                    }
                }
                if(currentDepth > maxDepth) maxDepth = currentDepth;

            }
            return maxDepth;
        }
    }


    public static void main(String[] args) {
        MaximumNumberOfMoves_2684.Solution s = new Solution();
        int[][] grid = new int[][] {{2,4,3,5},{5,4,9,3},{3,4,2,11},{10,9,13,15}};
        grid = new int[][] {{3,2,4},{2,1,9},{1,1,7}};
        System.out.println(s.maxMoves(grid));
    }
}
