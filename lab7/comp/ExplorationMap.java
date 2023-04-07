import java.util.ArrayList;


import java.util.*;
public class ExplorationMap {
    public static Cell[][] matrix=new Cell[3][3];
    public boolean visit(int row, int col, Robot robot) {
        synchronized (matrix[row][col]) {
            if(matrix[row][col].getVizited()==0){
                matrix[row][col].setTokens(SharedMemory.extractTokens(matrix.length));
                matrix[row][col].setVizited(1);
                System.out.println("Am reusit sa stochez urmatoarea celula: " + matrix[row][col] +" pe pozitia matrice[" + row+ "]["+col+"]");
                return true;
            }
        }
        return false;
    }
public static boolean existPosition()
{
    for(int i=0;  i<matrix.length; i++)
        for(int j=0;  j<matrix.length; j++)
            if(matrix[i][j].getVizited()==0)
                return true;
        return false;
}
    @Override
    public String toString() {
        return "ExplorationMap{" +
                "matrix=" + matrix[1][1] +
                '}';
    }

    public ExplorationMap(int n) {
        for (int i=0; i<n; i++) {
            for (int j = 0; j < n; j++)
            {
                List<Token> t=new ArrayList<>();
                t.add(new Token(0));
                Cell c=new Cell();
                c.setTokens(t);
                matrix[i][j] = c;
        }  }
    }
}
