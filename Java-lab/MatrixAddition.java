import java.util.Scanner;

public class MatrixAddition {
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of rows and cols:\n");
        int n = sc.nextInt();

        int [][] matrix1 = new int[n][n];
        int [][] matrix2 = new int[n][n];
        int [][] result = new int[n][n];

        System.out.println("Enter the elements of matrix1:\n");
        for (int i = 0 ; i < n ; i++){
            for(int j =0 ; j < n ; j++){
                matrix1[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter the elements of matrix2:\n");
        for (int i = 0 ; i < n ; i++){
            for(int j =0 ; j < n ; j++){
                matrix2[i][j] = sc.nextInt();
            }
        }

        for (int i = 0 ; i < n ; i++){
            for(int j =0 ; j < n ; j++){
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        System.out.println("Addition matrix is :\n");
        for (int i = 0 ; i < n ; i++){
            for(int j =0 ; j < n ; j++){
                System.out.print(result[i][j]+"\t");
            }
            System.out.println();
        }
        sc.close();
    }
}

