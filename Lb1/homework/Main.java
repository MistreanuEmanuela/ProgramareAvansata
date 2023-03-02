public class Main {
    public static void validateArgv(double arg)
    {
        int a;
        a=(int)arg;
        if(a!=arg)
        {
            System.out.println("Invalid argument");
            System.exit(-1);
        }
    }
    public static int[][] createMatrixLatinSquare(int size)
    {
        int[][] matrice=new int[size][size];
        int i, j;
        for(i=0; i<=size-1; i++){
            for(j=0;j<=size-1;j++){
                if(i<=j)
                    matrice[i][j]=j+1-i;
                else
                    matrice[i][j]=(size+j)-(i-1);
            }
        }
        return matrice;
    }
    public static String createStringFromLine(int i, int[][] matrice)
    {
        int j=0;
        String line=new String();
        for(j=0; j<=matrice.length-1;j++)
            line=line+matrice[i][j];
        return line;
    }
    public static String createStringFromColumn(int i, int[][] matrice)
    {
        int j=0;
        String column=new String();
        for(j=0; j<=matrice.length-1;j++)
            column=column+matrice[j][i];
        return column;
    }
    public static void desplayMatrix(int[][] matrice)
    {
        int i;
        for(i=0; i<=matrice.length-1; i++){
            System.out.println("Linia " +i+ " sub forma de string este: "+ createStringFromLine(i, matrice));
            System.out.println("Coloana " +i+ " sub forma de string este: "+ createStringFromColumn(i, matrice));
        }
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        if (args.length < 1) {
            System.out.println("Nu ati introdus n!");
            System.exit(-1);
        }
        validateArgv(Double.parseDouble(args[0]));
        int size=Integer.parseInt(args[0]);
        int[][] matrice=new int[size][size];
        matrice=createMatrixLatinSquare(size);
        if(size<100){
            desplayMatrix(matrice);
        }
        long end   = System.nanoTime();
        long time = end - start;
        System.out.println("Timpul de rulare in nanosecunde este: "+time);
    }
}
