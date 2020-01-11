package printRectangle;

public class RotateRectangle {
    public void rotate(int[][] matrix){
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR < dR){
            rotateEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    public void rotateEdge(int[][] m, int tR, int tC, int dR, int dC){
        int times = dC - tC;
        int tmp;
        for (int i = 0; i != times; i++){
            tmp = m[tR][tC + i];
            m[tR][tC + i] = m[dR - i][tC];
            m[dR - i][tC] = m[dR][dC - i];
            m[dR][dC - i] = m[tR + i][dC];
            m[tR + i][dC] = tmp;
        }
    }
}
