// CS-404, Fall 2019, Assignment 5 Solutions
// SOLUTIONS


public class Asst_5_SOLNS{ 


   public static void main(String [] args)  {

      System.out.println("SOLUTIONS");
      System.out.println("CS-404, Fall 2019, Assignment 5");
      
      A5_Helper.runProblem2();
      A5_Helper.runProblem3();
      A5_Helper.runProblem4();
      A5_Helper.runProblem5();
      A5_Helper.runProblem6();
      A5_Helper.runProblem7();

   }

//////////////////////////////////////////////////////////////////////
// Problem 2

   public static void printTree(int n, int [] nearest) {
   
      int i;
      System.out.print("{");
      
      if (nearest[n] == n) {
         for (i = 1; i <= n-2; i++)
            System.out.print("{" + i + ", " + nearest[i] + "}, ");
         System.out.println("{" + i + ", " + nearest[i] + "}}");
      }
      
      else  {
         for (i = 1; i <= n-1; i++)
            if (i != nearest[i])
               System.out.print("{" + i + ", " + nearest[i] + "}, ");
         System.out.println("{" + i + ", " + nearest[i] + "}}");
      }            
   }

   public static int prim(int n, int [][] W, int s, int [] nearest) {
   	
      int i, j, min, vnear = 0, cost = 0;
   	int [] dist = new int[n+1];
	
   	for (i = 1; i <= n; i++) {
   		nearest[i] = s;
		   dist[i] = W[s][i];
   	}

   	for (j = 1; j <= n - 1; j++)
   	{
   		min = inf;
   		for (i = 1; i <= n; i++)
   			if (dist[i] < min  &&  dist[i] > 0)
   			{
   				min = dist[i];
   				vnear = i;
   			}
            
         if (min == inf)
            return -1;
   
   		cost += min;
   		dist[vnear] = 0;
   
   		for (i = 1; i <= n; i++)
   			if (W[vnear][i] < dist[i])
   			{
   				dist[i] = W[vnear][i];
   				nearest[i] = vnear;
   			}
   	}
   	return cost;
   }

//////////////////////////////////////////////////////////////////////
// Problem 3

   public static void dijkstra(int n, int [][] W, int s, int [] touch, int [] pathCost) {

   	int i, j, min, vnear = 0;
   	int [ ] length = new int[n+1];
   	for (i = 1; i <= n; i++) {

   		touch[i] = s;
   		length[i] = W[s][i];
   	}

   	for (j = 1; j <= n - 1; j++) {

   		min = inf;
   		for (i = 1; i <= n; i++)
   			if (length[i] < min  &&  length[i] > 0) {
            
   				min = length[i];
   				vnear = i;
   			}
   
   		for (i = 1; i <= n; i++) {
   			if (length[vnear] + W[vnear][i] < length[i]) {

   				length[i] = length[vnear] + W[vnear][i];
   				touch[i] = vnear;
   			}
         }
   			
   		pathCost[vnear] = length[vnear];
   		length[vnear] = 0;
   	}
   }


//////////////////////////////////////////////////////////////////////
// Problem 4

   public static void dijkstraPrintPath(int s, int d, int [] touch)  {
   
      String path = "v" + d;
      while (s != d)
      {
         d = touch[d];
         path = ("v"+d + " ") + path;
      }
      System.out.print(path);
   }


//////////////////////////////////////////////////////////////////////
// Problem 5

   public static int [] smarterGreedyAlgorithm1 (int n, int k, int [] D) {        

      int i, startCoin, amtLeft, numCoins, totalCoins;
      int minSoFar = inf;
      int [] A; 
      int [] Best = new int[k+1];
      
      for (startCoin = k; startCoin >= 1; startCoin--)  {
   
         A = new int[k+1];
         amtLeft = n;
         totalCoins = 0;
         i = startCoin;
      
         while (amtLeft > 0)  {
           
            numCoins = amtLeft / D[i];            
            A[i] = numCoins;
            totalCoins += numCoins;
            amtLeft = amtLeft % D[i];
            i--;
         }
      
         if (totalCoins < minSoFar)  {
            Best[0] = totalCoins;
            minSoFar = totalCoins;
            for(i = 1; i <= k; i++) {
              Best[i] = A[i];
            }
         } 
      }

      return Best;
   }
   
// Counterexample: n = 54 cents, k = 4, D is {1, 8, 13, 19}.   
// smarterGreedyAlgorithm uses 6 coins.
// Use 4 coins:  two 19c and two 8c.
   
   
//////////////////////////////////////////////////////////////////////
// Problem 6
// 
// Assumes arrays already sorted in descending order by price per pound.
//

   public static double [] greedyFractionalKnapsack(int n, double capacity, double [] profit, double [] weight) {
   
      double quantity [] = new double[n+1];
      
      double totalProfit = 0, totalWeight = 0;
      
      int i = 1;
      
      while (totalWeight < capacity  &&  i <= n)  {
      
         if (totalWeight + weight[i] <= capacity) {
         
            totalProfit += profit[i];
            totalWeight += weight[i];
            quantity[i] = 1.0;
            i++;
         }
      
         else {
            quantity[i] = (capacity - totalWeight) / weight[i];
            totalProfit +=  quantity[i] * profit[i];
            totalWeight +=  quantity[i] * weight[i];
         }
      }
         
      quantity[0] = totalProfit;
      
      return quantity;
   }
         

//////////////////////////////////////////////////////////////////////
// Problem 7
         
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

// ===== done ===========================================================================   
   
   public static int inf = Integer.MAX_VALUE - 100000;
   
} // end class
   
      
   


      

