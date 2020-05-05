// CS-404, Fall 2019, Assignment 2 Solutions

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class CS_404_Asst2_SOLNS { 

//////////////////////////////////////////////////////////////////////
// Problem 1

public static int numWaysChange (int n, int k, int [] D) {       
   if (n < 0)
      return 0;
   else if (n == 0)
      return 1;
   else if (k == 1)
      return (n % D[1] == 0 ? 1 : 0);
   else
      return (numWaysChange(n, k-1, D) + numWaysChange(n - D[k], k, D));
}

//////////////////////////////////////////////////////////////////////
// Problem 2

public static int binarySearch(int [] A, int low, int high, int x)  {

   if (low > high)
      return -1;
   else {
      int m = (low + high)/2;
      if (x == A[m])
         return m;
      else if (x > A[m])
         return binarySearch(A, m+1, high, x);
      else
         return binarySearch(A, low, m-1, x);
   }
}

//////////////////////////////////////////////////////////////////////
// Problem 3

public static int partition(int [] A, int low, int high)  {

   int i, j = low, temp, pivotValue = A[low];
   
   for (i = low + 1; i <= high; i++) {
      
      if (A[i] < pivotValue) {
         j++;
         swap(A, i, j);
      }
   } // end for loop
   
   swap(A, low, j);
   return j;
}
         
//////////////////////////////////////////////////////////////////////
// Problem 4

public static int indexOfMinElt(int [] A, int low, int high)  {

   if (low == high)
      return low;

   else  {
      int temp = indexOfMinElt(A, low + 1, high);
      return (A[low] < A[temp] ? low : temp);         
   }
   
   // running time:  O(n)
}
         
//////////////////////////////////////////////////////////////////////
// Problem 5

public static void sortRec(int [] A, int low, int high)  {

   if (low < high) {

      int temp = indexOfMinElt(A, low, high);
      swap(A, low, temp);
      sortRec(A, low + 1, high);      
   }
   
   // running time n*O(n) = O(n^2).
}

//////////////////////////////////////////////////////////////////////
// Problem 6
/*

Weigh coins 1, 2, 3 against coins 4, 5, 6.  If (1, 2, 3) is heavier, then the counterfeit 
coin is 1, 2, or 3.  If (4, 5, 6) is heavier, it is 4, 5, or 6.  If they are equal, then
it is 7, 8, or 9.  Without loss of generality, assume it is 1, 2, or 3.  For the second 
weighing, weigh 1 against 2.  If they weigh the same, the counterfeit is 3. Otherwise, the 
counterfeit is the heavier of 1 and 2.   
*/


//////////////////////////////////////////////////////////////////////
// Problem 7
/*

If n = 1, then coin 1 is the counterfeit.
Otherwise, divide the coins into three groups G1, G2, and G3, each of size n/3. 
Weight G1 against G2.  If they are equal, then the counterfeit is in G3. Otherwise, the
counterfeit is in the heavier of G1 or G2. So with only one weighing, we have reduced the
number of coins in consideration from n to n/3.  

Let T(n) = # weighings used by this algorithm, then:

T(1) = 0.
T(n) = 1 + T(n/3).

The solution to this is T(n) = log_3(n).   
*/

//////////////////////////////////////////////////////////////////////
// Problem 8

public static double average(double [] A, int low, int high)  {

   if (low == high) 
      return A[low];
   else {
   
      int m = (low + high)/2;
      return 
         (average(A, low, m) + average(A, m+1, high))/2;
   }
}

//////////////////////////////////////////////////////////////////////
// Problem 9

public static BigInteger prod(BigInteger u, BigInteger v)  {
   
   BigInteger TEN = new BigInteger("10");
   BigInteger x, y, w, z, r, p, q, TEN_to_m, TEN_to_2m;
   int m, n;
   
   n = Math.max(numDigits(u), numDigits(v));
   m = n/2;
      
   if (n == 1)
      return u.multiply(v);
   else {
   
      TEN_to_m = TEN.pow(m);
      TEN_to_2m = TEN.pow(2*m);   
      x = u.divide(TEN_to_m);
      y = u.mod(TEN_to_m);
      w = v.divide(TEN_to_m);
      z = v.mod(TEN_to_m);
      
      r = prod(x.add(y), w.add(z));
      p = prod(x, w);
      q = prod(y, z);
      
      BigInteger first = p.multiply(TEN_to_2m);
      BigInteger second = (r.subtract((p.add(q)))).multiply(TEN_to_m);
   
      return first.add(second).add(q);
   }
}



//////////////////////////////////////////////////////////////////////
// Problem 10
// Trace through prod(2132, 1345):

/*
   See separate text file.
*/

//////////////////////////////////////////////////////////////////////
// Problem 11

public static int combinations(int n, int k)  {

   if (k == 0 || k == n)
      return 1;
   else
      return (combinations(n-1, k-1) + combinations(n-1, k));
}

   
//////////////////////////////////////////////////////////////////////
// Problem 12

public static int [] closestPair(int n, Point [] Q) {
  
  int [] ans = {-1, 0, 0};
  double minDist = distance(Q[1], Q[2]);
  int index1 = 1, index2 = 2;
  
  for (int i = 1; i <= n; i++)
   for (int j = i+1; j <= n; j++)
      if (distance(Q[i], Q[j]) < minDist)  {
         index1 = i;
         index2 = j;
         minDist = distance(Q[i], Q[j]);
      }
       
         
   ans[1] = index1;
   ans[2] = index2;     
  
  return ans;
}

public static double distance(Point a, Point b) {
   
   return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
}

//////////////////////////////////////////////////////////////////////
// Problem 13

public static int counterfeit(int low, int high) {

   System.out.println("Considering coins " + low + " ... " + high);

   if (low == high)
      return low;
   
   int numPerGroup = (high - low + 1)/3;
   int low1, high1, low2, high2;
   
   low1 = low;
   high1 = low1 - 1 + numPerGroup;
   low2 = high1 + 1;
   high2 = low2 - 1 + numPerGroup;
   
   System.out.println("Which is heavier?:  coins (" + low1 + " ... " + high1 + 
                      ")  or coins  (" + low2 + " ... " + high2 + ")");
   
   int balResult = balance(low1, high1, low2, high2);
   
   if (balResult == 1)
      return counterfeit(low1, high1);
   else if (balResult == 2)
      return counterfeit(low2, high2);
   else
      return counterfeit(high2 + 1, high);
}



public static void printArray(int n, double [] A) {
   
   for (int i = 1; i <= n; i++)
      System.out.print(A[i] + " ");
   System.out.println();
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
