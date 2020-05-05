// YOURNAME
//
// CS-404, Asst 4, Fall 2019

import java.util.Scanner;
import java.io.*;         

public class CMM_YOURNAME  {

   static String name = "YOURNAME";
   
   public static double minMult(int n, double [] d, double [][] M, int [][] P) {



      return 1.0;
   }  // end minMult method
   

   public static double maxMult(int n, double [] d, double [][] M, int [][] P) {



      return 1.0;
   }  // end maxMult method

   

   public static void printOrder(int i, int j, int [][] P)  {



   }  // end printOrder



	public static void main(String[] args) throws IOException  {
      
      System.out.println("\n" + name);
      System.out.println("CS-404, Asst 4, Fall 2019\n\n");

      Scanner input = new Scanner(new FileReader("cmm_input.txt"));
      int i, n;
      double minCost, maxCost;
      n = input.nextInt();
      
      while (n > 0)  {

         int [][] P  = new int[n+1][n+1];
         double [] d  = new double[n+1];
         double [][] M  = new double[n+1][n+1];
         
         for (i = 0; i <= n; i++)
            d[i] = input.nextDouble();
      
         minCost = minMult(n, d, M, P);
         
         System.out.printf("Minimum Cost to multiply: %1.0f multiplications.", minCost);
         System.out.println("\n");
         System.out.print("Optimal Order:  ");
         printOrder(1, n, P);
         System.out.println("\n");

         maxCost = maxMult(n, d, M, P);

         System.out.printf("Maximum Cost to multiply: %1.0f multiplications.", maxCost);
         System.out.println("\n");
         System.out.print("Worst Order:  ");
         printOrder(1, n, P);
         System.out.println("\n");
         
         System.out.println("ratio:   " + (maxCost / minCost));
         System.out.println("\n");
         
         n = input.nextInt();

	   } // end while loop
   } // end main
   
} // end class
		
		