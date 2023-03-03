import java.util.Arrays;

public class Main {
    public static int[][] createAdjacencyMatrixOfCycleGraph(int n)
    {
        int[][] A=new int[n][n];
        for(int i=1;i<=n-2; i++) {
            A[i][i + 1] = 1;
            A[i][i - 1] = 1;
        }
        A[0][n-1]=1;
        A[0][1]=1;
        A[n-1][n-2]=1;
        A[n-1][0]=1;
        return A;
    }
    public static int[][] matrixMultiplication(int[][] matrix1, int[][] matrix2)
    {
        int[][] result=new int[matrix1.length][matrix2.length];
        for(int i=0; i<=matrix1.length-1; i++) {
            for (int j = 0; j <= matrix2.length-1; j++) {
                result[i][j]=0;
                for(int k=0; k<=matrix1.length-1; k++)
                    result[i][j]=result[i][j]+matrix1[i][k]*matrix2[k][j];
            }
        }
        return result;
    }
    public static int[][] matrixOnPowerN(int[][] matrix, int power) {
        int contor = 1;
        int[][] matrixn = new int[matrix.length][matrix.length];
        matrixn = matrix;
        while (contor < power) {
            matrixn = matrixMultiplication(matrixn, matrix);
            contor++;
        }
        return matrixn;
    }
    public static void main(String[] args) {
        int n=3;
        int[][] matrice=new int[n][n];
        matrice=createAdjacencyMatrixOfCycleGraph(n);
        System.out.println(Arrays.deepToString(matrice));
        int[][] matrix=new int[n][n];
        matrix=matrice;
         for(int i=1; i<=n; i++)
        System.out.println("A^"+i+": "+ Arrays.deepToString(matrixOnPowerN(matrix,i)));

    }
}
