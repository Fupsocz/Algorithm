package printRectangle;

public class ZigZag {

    /**
     * 之字形打印矩阵
     * @param matrix
     */

    public static void printZigZag(int[][] matrix){

        // row column
        int ar = 0;
        int ac = 0;
        int br = 0;
        int bc = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        boolean fromUp = false;
        while(ar != endR + 1){
            printDiagonal(matrix, ar, ac, br, bc, fromUp);
            ar = ac == endC ? ar + 1 : ar;
            ac = ac == endC ? ac : ac + 1;
            br = br == endR ? br : br + 1;
            bc = br == endR ? bc + 1 : bc;
            fromUp = !fromUp;
        }
    }


    public static void printDiagonal(int[][] matrix, int ar, int ac, int br, int bc, boolean fromUp){
        if (fromUp){
            while(ar != br + 1){
                System.out.println(matrix[ar++][ac--] + "");
            }
        } else{
            while(br != ar - 1){
                System.out.println(matrix[br--][bc++] + "");
            }
        }
    }
}
