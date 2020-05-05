// CS-404, Fall 2019, Assignment 2 Template

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;



public class CS_404_Asst2_template_updated { 

//////////////////////////////////////////////////////////////////////
// Problem 1

public static int numWaysChange (int n, int k, int [] D) {       

      return 0;
}

//////////////////////////////////////////////////////////////////////
// Problem 2

public static int binarySearch(int [] A, int low, int high, int x)  {

   return -1;

}

//////////////////////////////////////////////////////////////////////
// Problem 3

public static int partition(int [] A, int low, int high)  {

   return 1;
}
         
//////////////////////////////////////////////////////////////////////
// Problem 4

public static int indexOfMinElt(int [] A, int low, int high)  {

   return -1;

}
         
//////////////////////////////////////////////////////////////////////
// Problem 5

public static void sortRec(int [] A, int low, int high)  {


}

//////////////////////////////////////////////////////////////////////
// Problem 6
/*




*/


//////////////////////////////////////////////////////////////////////
// Problem 7
/*



*/

//////////////////////////////////////////////////////////////////////
// Problem 8

public static double average(double [] A, int low, int high)  {

   return 0.0;
}

//////////////////////////////////////////////////////////////////////
// Problem 9

public static BigInteger prod(BigInteger u, BigInteger v)  {


   
   
   
   
   return BigInteger.ZERO;
}

//////////////////////////////////////////////////////////////////////
// Problem 10
// Trace through prod(2132, 1345):

/*


*/

//////////////////////////////////////////////////////////////////////
// Problem 11

public static int combinations(int n, int k)  {

   return -1;
}

   
//////////////////////////////////////////////////////////////////////
// Problem 12

public static int [] closestPair(int n, Point [] Q) {
  
  int [] ans = {-1, -1};
  
  
  
  
  return ans;
}


//////////////////////////////////////////////////////////////////////
// Problem 13

public static int counterfeit(int n) {

   return 1;
}
  



//////////////////////////////////////////////////////////////////////
// Testing

public static void main(String [] args){







}


public static void printArray(int n, int [] A) {
   
   for (int i = 1; i <= n; i++)
      System.out.print(A[i] + " ");
   System.out.println();
}

public static void swap(int [] A, int i, int j) {
   
   int temp = A[i];
   A[i] = A[j];
   A[j] = temp;
}

public static int numDigits(BigInteger u) {

   return u.toString().length();
}


public static int balance(int low1, int high1, int low2, int high2) {

   Scanner kbd = new Scanner(System.in);

   System.out.print("Enter 1, 2, or 0:  ");
   return kbd.nextInt();
}




} // end class
