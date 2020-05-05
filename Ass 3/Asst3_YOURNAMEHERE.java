// !!!!!!!!!!!!!!!PUT YOUR NAME HERE!!!!!!!!!!!!!!!!!!!!!!
//
// Assignment 3, CS-404, Fall 2019

import java.util.Scanner;
import java.io.*;         

public class Asst3_YOURNAMEHERE  {


   public static void Floyd(int n, int [][] W, int [][] D, int [][] P) {
   
   
   
   
   } // end Floyd


   public static void printPath(int s, int d, int [][] P)  {
    
   
   
   }  // end printPath
   

   public static void printPathWithEndpoints(int s, int d, int [][] P)  {



   } // end printPathWithEndpoints
   
      
   

   public static int maxEdgesInOneOptPath(int n, int [][] P)   {


      
      return -1;
   }



   


	public static void main(String[] args) throws IOException  {
      
      Scanner kbd = new Scanner(System.in);
      Scanner input;
      
      String inputFileName;
      System.out.print("\nEnter input file name:  ");
      inputFileName = kbd.nextLine();
      FileReader f = new FileReader(inputFileName);
      input = new Scanner(f);
      
      int i, j, n;
      n = input.nextInt();
      System.out.println();
      
      int [][] W = new int[n+1][n+1];
      int [][] D = new int[n+1][n+1];
      int [][] P = new int[n+1][n+1];
      
      for (i = 1; i <= n; i++) 
         for (j = 1; j <= n; j++)
            W[i][j] = input.nextInt();
      
      
      System.out.println("W is:  ");
      printArray(n, W);
      
      Floyd(n, W, D, P);
      
      System.out.println("D is:  ");
      printArray(n, D);

      System.out.println("P is:  ");
      printArray(n, P);
      
      System.out.print("\nThe maximum number of edges in a least-cost path is:  ");
      System.out.println(maxEdgesInOneOptPath(n, P) + "\n");
      
      System.out.println("\nShortest paths, intermediates only: \n");
      for (i = 1; i <= n; i++)  {
         for (j = 1; j <= n; j++)  {
            System.out.print("v_" + i + " to v_" + j + ":  ");
            printPath(i, j, P);
            System.out.println();
         }
         System.out.println();
      }

      System.out.println("\n\nShortest paths, all vertices: \n");
      for (i = 1; i <= n; i++)  {
         for (j = 1; j <= n; j++)  {
            printPathWithEndpoints(i, j, P);
            System.out.println();
         }
         System.out.println();
      }

	}  // end main
   
   
   
   public static void printArray(int n, int [][] A) {
      int i, j;
      System.out.println();
      System.out.print("       ");
      
      for (i = 1; i <= n; i++)
         System.out.printf("%7d", i);
      System.out.println("\n");

      for (i = 1; i <= n; i++) {
         System.out.printf("%7d", i);
         for (j = 1; j <= n; j++)
            System.out.printf("%7d", A[i][j]);
         System.out.println();
      }
      
      System.out.println();
   } // end printArray
               
            
}  // end class
		
		