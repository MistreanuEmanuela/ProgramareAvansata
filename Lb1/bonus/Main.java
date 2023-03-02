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
public static int[][] createAdjacencyMatrixRegularGraph(int vertices, int vertex)
{
    int[][] matrix=new int[vertices][vertices];
    for(int i=0; i<=vertices-1; i++) {
        int contor = 0;
        for (int j = 0; j <= i; j++)
            if (matrix[i][j] == 1)
                contor++;
        if (contor != vertex)
            for (int j = i + 1; j <= i + vertex - contor; j++) {
                matrix[i][j] = 1;
                matrix[j][i] = 1;
            }
    }
    return matrix;
}
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Nu ati introdus suficiente argumente!");
            System.exit(-1);
        }
        int n=3;
        int[][] matrice=new int[n][n];
        matrice=createAdjacencyMatrixOfCycleGraph(n);
        System.out.println(Arrays.deepToString(matrice));
        int[][] matrix=new int[n][n];
        matrix=matrice;
        System.out.println(Arrays.deepToString(matrixOnPowerN(matrix,3)));
        int vertices=Integer.parseInt(args[0]);
        int vertex=Integer.parseInt(args[1]);
        int[][] matr=new int[vertices][vertices];
        matr=createAdjacencyMatrixRegularGraph(vertices,vertex);
        System.out.println(Arrays.deepToString(matr));
    }
}
