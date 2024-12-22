/**
 * given an M * N matrix containing only values 0 and 1 , the task is to count the number of square subMatrices
 * containing all ones.
 */
class PracticeProblemOct27 {

    /*
        this is the Native bruteforce approach that i will be using to calculate the SubMatrices With all Ones.
        the time complexity of this approach is estimated to be O(N^3) because for each element in the matrix
        we compute if there is any valid SubMatrix , which is going to take O(N^2).

        Thus the run time of this brute force approach is O(N^3)
     */

    public boolean containsAllOnes_1(int initialRow , int initialCol,
                                     int left_row , int left_col , int[][] matrix){
        boolean containsAllOnes = true;
        for(int a = initialRow; a <= left_row ; a ++){
            for(int b = initialCol; b <= left_col ; b++){
                if(matrix[a][b] == 0 && containsAllOnes) {
                    containsAllOnes = false;
                    break;
                }
            }
        }

        return containsAllOnes;
    }
    public int countSubMatricesWithAllOnes_1(int[][] matrix){
        int answer = 0;
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                if(matrix[i][j] == 0) continue;
                // if the value of the left Most corner of the matrix is a zero we return 0
                // as we cannot form further sub matrices.
                int left_most_row = i;
                int left_most_col = j;
                while(left_most_row < matrix.length && left_most_col < matrix[0].length){
                    if(containsAllOnes_1(i,j,left_most_row,left_most_col,matrix)) {
                        answer++;
                        left_most_row ++;
                        left_most_col ++;
                    }
                    else break;
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        PracticeProblemOct27 practiceProblemOct27 = new PracticeProblemOct27();
        int[][] array = new int[][]{
                {0,1,1,1},
                {1,1,1,1},
                {0,1,1,1}};
        System.out.println(practiceProblemOct27.countSubMatricesWithAllOnes_1(array));
    }
}
