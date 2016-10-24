package lab02;

import java.util.Random;
import java.util.Arrays;

/**
 * @author Hamza Mahmood
 * BSCS-4B 33093
 * 
 * Methods I have written:
 * itrMatrixMult()
 * randPop()
 * padMat() -> function that returns padded matrix with dimension 2^n(cube matrix)
 * Obj class
 * -------------------------------------------------------------------------------------------
 * I do not own the functions i.e i have not written them
 * These functions are taken from : http://www.sanfoundry.com/java-program-strassen-algorithm/
 * multiply()
 * add()
 * sub()
 * split()
 * join()
 * The part of code taken from the link also only performs multiplication 2^n size matrix
 * --------------------------------------------------------------------------------------------
 */
public class Lab02 {
     //Iterative Matrix Multiplication
    public static int[][] itrMatrixMult(int[][] x,int[][] y){
        int rowX = x.length;
        int rowY = y.length;
        
        int colX = x[0].length;
        int colY = y[0].length;
        
        //n x m == m x p
        //if colX is not equal to colY multiplication not possible
        if(colX != rowY ){
            throw new IllegalArgumentException("Cols of x: " + colX + " are not equal to Rows of Y: " + rowY);
        }
        
        int[][] result = new int[rowX][colY];
        
        for(int i = 0;i < rowX ;i++){
            for(int j = 0;j < colY ;j++ ){
                for(int k = 0;k < colX ;k++){
                    result[i][j] = result[i][j] + (x[i][k] * y[k][j]);
                }
            }
        }
        
        return result;
    }
    public static Obj padMat(int[][] x,int[][] y){
        int rowX = x.length;
        int rowY = y.length;
        
        int colX = x[0].length;
        int coly = y[0].length;
        
        int max = Math.max(Math.max(Math.max(rowX,rowY),colX),coly);
        int len = 0;
        if ((max & (max-1)) == 0){//if max is 2^n
            len = max;
        }
        else{
            for(int i = max;;i++){
                if((i & (i-1))==0){
                    len = i;
                    break;
                }
            }
        }
        int[][] r1 = new int[len][len];
        int[][] r2 = new int[len][len];
        System.out.println(len);
        for(int i=0;i<rowX;i++){
            for(int j=0;j<colX;j++){
                r1[i][j] = x[i][j];
            }
        }

        for(int i=0;i<rowY;i++){
            for(int j=0;j<coly;j++){
                r2[i][j] = y[i][j];
            }
        }
        Obj obj = new Obj(r1,r2);
        return obj;
    }
    public static void randPop(int[][] a, int rows, int cols){
        Random randomValue = new Random();

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                int randomInt = randomValue.nextInt(10);
                a[i][j] = randomInt;
            }
        }
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////
        public static int[][] multiply(int[][] A, int[][] B)
    {        

        int n = A.length;

        int[][] R = new int[n][n];

        /** base case **/

        if (n == 1)

            R[0][0] = A[0][0] * B[0][0];

        else

        {

            int[][] A11 = new int[n/2][n/2];

            int[][] A12 = new int[n/2][n/2];

            int[][] A21 = new int[n/2][n/2];

            int[][] A22 = new int[n/2][n/2];

            int[][] B11 = new int[n/2][n/2];

            int[][] B12 = new int[n/2][n/2];

            int[][] B21 = new int[n/2][n/2];

            int[][] B22 = new int[n/2][n/2];

 

            /** Dividing matrix A into 4 halves **/

            split(A, A11, 0 , 0);

            split(A, A12, 0 , n/2);

            split(A, A21, n/2, 0);

            split(A, A22, n/2, n/2);

            /** Dividing matrix B into 4 halves **/

            split(B, B11, 0 , 0);

            split(B, B12, 0 , n/2);

            split(B, B21, n/2, 0);

            split(B, B22, n/2, n/2);

 

            /** 

              M1 = (A11 + A22)(B11 + B22)

              M2 = (A21 + A22) B11

              M3 = A11 (B12 - B22)

              M4 = A22 (B21 - B11)

              M5 = (A11 + A12) B22

              M6 = (A21 - A11) (B11 + B12)

              M7 = (A12 - A22) (B21 + B22)

            **/

 

            int [][] M1 = multiply(add(A11, A22), add(B11, B22));

            int [][] M2 = multiply(add(A21, A22), B11);

            int [][] M3 = multiply(A11, sub(B12, B22));

            int [][] M4 = multiply(A22, sub(B21, B11));

            int [][] M5 = multiply(add(A11, A12), B22);

            int [][] M6 = multiply(sub(A21, A11), add(B11, B12));

            int [][] M7 = multiply(sub(A12, A22), add(B21, B22));

 

            /**

              C11 = M1 + M4 - M5 + M7

              C12 = M3 + M5

              C21 = M2 + M4

              C22 = M1 - M2 + M3 + M6

            **/

            int [][] C11 = add(sub(add(M1, M4), M5), M7);

            int [][] C12 = add(M3, M5);

            int [][] C21 = add(M2, M4);

            int [][] C22 = add(sub(add(M1, M3), M2), M6);

 

            /** join 4 halves into one result matrix **/

            join(C11, R, 0 , 0);

            join(C12, R, 0 , n/2);

            join(C21, R, n/2, 0);

            join(C22, R, n/2, n/2);

        }

        /** return result **/    

        return R;

    }

    /** Funtion to sub two matrices **/

    public static int[][] sub(int[][] A, int[][] B)

    {

        int n = A.length;

        int[][] C = new int[n][n];

        for (int i = 0; i < n; i++)

            for (int j = 0; j < n; j++)

                C[i][j] = A[i][j] - B[i][j];

        return C;

    }

    /** Funtion to add two matrices **/

    public static int[][] add(int[][] A, int[][] B)

    {

        int n = A.length;

        int[][] C = new int[n][n];

        for (int i = 0; i < n; i++)

            for (int j = 0; j < n; j++)

                C[i][j] = A[i][j] + B[i][j];

        return C;

    }

    /** Funtion to split parent matrix into child matrices **/

    public static void split(int[][] P, int[][] C, int iB, int jB) 

    {

        for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)

            for(int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)

                C[i1][j1] = P[i2][j2];

    }

    /** Funtion to join child matrices intp parent matrix **/

    public static void join(int[][] C, int[][] P, int iB, int jB) 

    {

        for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)

            for(int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)

                P[i2][j2] = C[i1][j1];

    }    
    public static void main(String[] args) {

    }
}
