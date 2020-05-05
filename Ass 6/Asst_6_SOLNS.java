// CS-404, Fall 2019, Assignment 6 Solutions
// SOLUTIONS

public class Asst_6_SOLNS { 

   public static void main(String [] args)  {

      System.out.println("SOLUTIONS");
      System.out.println("CS-404, Fall 2019, Assignment 6\n");
      
      int i, n, m;
      int [] vcolor;
      int [][] W;
      boolean done, found;


      System.out.println("\n======== Testing Problems 1, 2, and 3 ============================================\n");
      
      for (i = 1; i <= graphs.length - 1; i++)  {
      
         W = graphs[i];
         n = W.length - 1;

         vcolor = new int[n+1];
         System.out.println("\nGraph " + i + ", size = " + n + "\n");
         m = greedyColoring(n, W, vcolor);
         System.out.println(m + " colors are used by the Greedy Algorithm for Graph " + i + ":");
         printArray(n, vcolor);
        
         vcolor = new int[n+1];
         m = minNumColorsBacktracking(n, W, vcolor);
         System.out.println("\n" + m + " colors are necessary for Graph " + i + ":");
         printArray(n, vcolor);

         vcolor = new int[n+1];
         System.out.println("\nRunning fast two-coloring algorithm...");
         if (fastTwoColor(n, W, vcolor))  {
         
            System.out.println("2-coloring FOUND:");
            printArray(n, vcolor);
         }
         else  
            System.out.println("No 2-coloring found!");
    
         
         System.out.println();
         
      }
      
      
      System.out.println("\n======== Testing Problem 4 ============================================\n");
      
      int [] A1 = {-1, 3, 1, 4, 4};
      n = A1.length - 1;
      System.out.print("A is:  ");
      printArray(n, A1);
      done = getNextSequence(n, A1);
      System.out.println("Found next sequence is " + done);
      System.out.print("A is:  ");
      printArray(n, A1);
      
      int [] A2 = {-1, 5, 5, 5, 5, 5};
      n = A2.length - 1;
      System.out.print("\nA is:  ");
      printArray(n, A2);
      done = getNextSequence(n, A2);
      System.out.println("Found next sequence is " + done);
      System.out.print("A is:  ");
      printArray(n, A2);

      int [] A3 = {-1, 4, 7, 6, 7, 7, 7, 7};
      n = A3.length - 1;
      System.out.print("\nA is:  ");
      printArray(n, A3);
      done = getNextSequence(n, A3);
      System.out.println("Found next sequence is " + done);
      System.out.print("A is:  ");
      printArray(n, A3);
      
      
      System.out.println("\n======== Testing Problem 5 ============================================\n");
         
      int vcoloring [][] = 
      {
      {},
      {-1, 1, 2},
      {-1, 2, 1, 2},
      {-1, 1, 2, 3, 1},
      {-1, 1, 1, 2, 3, 3, 3, 4, 4},
      {-1, 1, 2, 1, 2, 3, 3, 3, 4, 1},
      {-1, 1, 1, 2, 1, 3, 5, 2, 2, 2, 3, 4, 5}, 
      {-1, 1, 1, 2, 1, 3, 5, 2, 2, 2, 3, 4, 5}, 
      {-1, 1, 1, 1, 1, 2, 2, 1, 2, 3, 3, 1, 2, 1, 3, 2, 2, 1, 3, 3, 2, 1, 2, 2, 4, 2}
      };
      
      for (i = 1; i <= graphs.length - 1; i++) {
      
         
         System.out.print("The coloring is valid for graph " + i + ":  ");
         System.out.println(validColoring(graphs[i].length - 1, graphs[i], vcoloring[i]));
      }


      System.out.println("\n======== Testing Problem 6 ============================================\n");
      
      int [] AA = {-1, 5, 3, 19, 3, 3, 5, 19, 4, 4, 27, 3, 3};
      n = AA.length - 1;
      System.out.println("Number of distinct values in AA is:  " + numDistinctValues(n, AA));
      
      int [] BB = {-1, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8};
      n = BB.length - 1;
      System.out.println("Number of distinct values in BB is:  " + numDistinctValues(n, BB));
      
      int [] CC = {-1, 9, 4, 1, 7, 3, 6, 2, 8, 5};
      n = CC.length - 1;
      System.out.println("Number of distinct values in CC is:  " + numDistinctValues(n, CC));



      System.out.println("\n======== Testing Problem 7 ============================================\n");


      for (i = 1; i <= 5; i++)  {
      
         W = graphs[i];
         n = W.length - 1;
                 
         m = minNumColorsBruteForce(n, W);
         System.out.println("\n" + m + " colors are necessary for Graph " + i + ":");
      }
               
   }

//////////////////////////////////////////////////////////////////////
// Problem 1

   public static boolean mColor(int n, int [][] W, int m, int [] vcolor)  {
   
      return mColorRec(0, n, W, m, vcolor);
      
   }  // end "mColorable"
   
   public static boolean mColorRec(int i, int n, int [][] W, int m, int [] vcolor)  {
   
      if (promising(i, W, vcolor))  {
      
         if (i == n)
            return true;
         
         else
            for (int t = 1; t <= m; t++)  {
            
               vcolor[i+1] = t;
               if (mColorRec(i+1, n, W, m, vcolor))
                  return true;
            }
      }
      
      return false;
   } // end "mColorRec"
   
   
   public static boolean promising(int i, int [][] W, int [] vcolor)  {
   
      for (int j = 1; j < i; j++)  
         if (W[i][j] == 1  &&  vcolor[i] == vcolor[j])
            return false;
      
      return true;
   }  // end "promising"


//////////////////////////////////////////////////////////////////////
// Problem 2

   public static int minNumColorsBacktracking(int n, int [][] W, int [] vcolor)  {
   
      int m = 1;
      while (!(mColor(n, W, m, vcolor)))
         m++;
      
      return m;
         
   }  // end "minNumColorsBacktracking"

//////////////////////////////////////////////////////////////////////
// Problem 3

   public static boolean fastTwoColor(int n, int [][] W, int [] vcolor)  {
   
      IntQueue q = new IntQueue();
      vcolor[1] = 1;
      q.enqueue(1);
      
      while (!q.isEmpty())  {

         int v = q.dequeue();
         
         for (int i = 1; i <= n; i++)  {
         
            if (W[i][v] == 1) {
            
               if (vcolor[i] == vcolor[v])
                  return false;
               
               if (vcolor[i] == 0)  {
           
                  vcolor[i] = 3 - vcolor[v];
                  q.enqueue(i);
               }
            }
         }
      }
      
      return true;
   } // end "twoColor"


//////////////////////////////////////////////////////////////////////
// Problem 4

   public static boolean getNextSequence(int n, int [] A)  {
   
      for (int i = n; i >= 1; i--) {
      
         if (A[i] < n) {
            A[i]++;
            return true;
         }
         else
            A[i] = 1;
      }
       
   
      return false;
   
   } // end "getNextSequence"


//////////////////////////////////////////////////////////////////////
// Problem 5

   public static boolean validColoring(int n, int [][] W, int [] vcolor)  {
   
      for (int i = 1; i <= n; i++)
         for (int j = i+1; j <= n; j++)
            if (W[i][j] == 1  &&  vcolor[i] == vcolor[j])
               return false;
               
      return true;
   
   } // end "validColoring"

   
//////////////////////////////////////////////////////////////////////
// Problem 6

   public static int numDistinctValues(int n, int [] A)  {
   
      int i, j, count = 0;
      
      for (i = 1; i <= n; i++) {
      
         int freq = 1;
         
         for (j = i+1; j <= n; j++)
            if (A[i] == A[j])
               freq++;
         
         if (freq == 1)
            count++;
      }
      
      return count;
   }// end "numDistinctValues"
   
         

//////////////////////////////////////////////////////////////////////
// Problem 7
         
   public static int minNumColorsBruteForce(int n, int [][] W)  {
   
      int i, m, min = Integer.MAX_VALUE;
      int [] vcolor = new int[n+1];
      
      for (i = 1; i <= n; i++)
         vcolor[i] = 1;
         
      do  {
      
         if (validColoring(n, W, vcolor))  {
            m = numDistinctValues(n, vcolor);
            if (m < min)
               min = m;
         }
      }
      while (getNextSequence(n, vcolor));
   
      return min;
   
   }  // end "minNumColorsBruteForce"
   

//////////////////////////////////////////////////////////////////////
// Auxiliary Methods

   public static void printArray(int n, int [] A) {
      for (int i = 1; i <= n; i++)
         System.out.print(A[i] + " ");
      System.out.println();
   }

// from Asst 5:
      
   public static int greedyColoring(int n, int [][] W, int [] vcolor)  {

      int color = 0, i, j;

      while(someUncolored(n, vcolor)) 
      {
      	color++;
      	for (i = 1; i <= n; i++) 
      		if (vcolor[i] == 0) 
      		{
      			vcolor[i] = color;
      			for (j = 1; j < i; j++)
      				if (W[i][j] == 1  &&  vcolor[i] == vcolor[j])
      					vcolor[i] = 0;
      		}
      }
      return color;
    }

   public static boolean someUncolored(int n, int [] vcolor)  
   {
      for (int i = 1; i <= n; i++)
    		if (vcolor[i] == 0) 
   			return true;
      return false;
   }         
          



//////////////////////////////////////////////////////////////////////
// Data

/*public static int [][] vcoloring = 

{
{},
{-1, 1, 1}
*/

public static int [][][] graphs = 

{
{}, 

// 1
{
{},
{-1, 0, 1},
{-1, 1, 0}
},

// 2
{
{},
{-1, 0, 1, 1},
{-1, 1, 0, 1},
{-1, 1, 1, 0}
},

// 3
{
{},
{-1, 0, 1, 0, 1},
{-1, 1, 0, 0, 1},
{-1, 0, 0, 0, 1},
{-1, 1, 1, 1, 0}
},


// 4
{
{},
{-1,0,0,0,1,0,1,0,1},
{-1,0,0,1,0,1,0,1,0},
{-1,0,1,0,0,0,1,0,1},
{-1,1,0,0,0,1,0,1,0},
{-1,0,1,0,1,0,0,0,1},
{-1,1,0,1,0,0,0,1,0},
{-1,0,1,0,1,0,1,0,0},
{-1,1,0,1,0,1,0,0,0}
},

// 5
{
{},
{-1,0,1,0,1,1,0,1,1,0},
{-1,1,0,0,0,1,1,0,0,1},
{-1,0,0,0,0,0,0,1,1,0},
{-1,1,0,0,0,0,0,1,1,1},
{-1,1,1,0,0,0,0,0,1,1},
{-1,0,1,0,0,0,0,0,0,1},
{-1,1,0,1,1,0,0,0,1,0},
{-1,1,0,1,1,1,0,1,0,1},
{-1,0,1,0,1,1,1,0,1,0}
},

// 6
{
{},
{-1,0,0,0,0,0,0,0,1,0,1,0,1},
{-1,0,0,1,0,0,0,1,1,0,1,0,0},
{-1,0,1,0,0,1,0,0,0,0,0,0,0},
{-1,0,0,0,0,1,0,0,0,1,0,1,0},
{-1,0,0,1,1,0,0,0,0,0,0,0,1},
{-1,0,0,0,0,0,0,1,1,0,0,0,0},
{-1,0,1,0,0,0,1,0,0,0,0,0,0},
{-1,1,1,0,0,0,1,0,0,0,0,1,0},
{-1,0,0,0,1,0,0,0,0,0,1,0,1},
{-1,1,1,0,0,0,0,0,0,1,0,1,0},
{-1,0,0,0,1,0,0,0,1,0,1,0,1},
{-1,1,0,0,0,1,0,0,0,1,0,1,0}
},


// 7
{
{},
{-1,0,0,0,1,0,0,0,0,0},
{-1,0,0,1,0,0,1,0,0,0},
{-1,0,1,0,0,1,0,0,1,0},
{-1,1,0,0,0,0,1,1,0,1},
{-1,0,0,1,0,0,1,1,1,0},
{-1,0,1,0,1,1,0,1,1,1},
{-1,0,0,0,1,1,1,0,1,0},
{-1,0,0,1,0,1,1,1,0,1},
{-1,0,0,0,1,0,1,0,1,0}
},

// 8
{
{},
{-1,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0},
{-1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,0,1},
{-1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,1,0,0,0},
{-1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,1,0,0,0,1,0,0,1,0,0},
{-1,0,1,0,0,0,0,1,0,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0},
{-1,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0},
{-1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,1,0,0,1,0,0,1,0,0,1},
{-1,0,0,0,1,0,0,0,0,0,1,1,0,1,0,0,0,0,0,0,0,1,0,0,0,0},
{-1,0,0,1,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,1,0},
{-1,1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,1,0,1,0,0,0},
{-1,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,1,1,0,0,0,1,0,0},
{-1,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
{-1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,1,1,0,0,1,0,0,1},
{-1,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,1,0,1},
{-1,0,0,1,1,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0},
{-1,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},
{-1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,1,1,1,0,0,1,0,0},
{-1,0,1,1,0,0,1,0,0,0,0,1,0,1,0,0,0,1,0,0,0,0,0,0,0,0},
{-1,0,0,0,0,0,1,1,0,0,0,1,0,1,0,0,0,1,0,0,0,0,0,0,1,0},
{-1,0,1,0,1,0,0,0,0,0,1,0,0,0,1,0,0,1,0,0,0,1,0,0,0,0},
{-1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,1},
{-1,0,0,1,0,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0},
{-1,0,0,0,1,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0},
{-1,1,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,1,0,0,1,0,0,1},
{-1,0,1,0,0,0,0,1,0,0,0,0,0,1,1,0,0,0,0,0,0,1,0,0,1,0}
}

};



   
} // end class
   
      
   


      

