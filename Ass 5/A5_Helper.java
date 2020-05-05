// CS-404, Fall 2019, Assignment 5 Helper Method

import java.util.Random;
import java.util.Scanner;

public class A5_Helper { 

   public static void main(String [] args)  {
   
      

   }


      
   public static void runProblem2() {
   
      int n;   

      System.out.println("\n======== Testing Problem 2 ============================================\n");
      
      int [] nearest;
      
      n = graph1.length - 1;
      nearest = new int[n+1];
      testProblem_2(n, graph1, 3, nearest);

      testProblem_2(n, graph1, 7, nearest);

      n = graph2.length - 1;
      nearest = new int[n+1];
      testProblem_2(n, graph2, 4, nearest);

      n = graph3.length - 1;
      nearest = new int[n+1];
      testProblem_2(n, graph3, 1, nearest);
      
      n = gg2.length - 1;
      nearest = new int[n+1];
      testProblem_2(n, gg2, 1, nearest);
   }
   
   

   public static void runProblem3() {

      System.out.println("\n======== Testing Problem 3 ============================================\n");
      int n;   

      int [] touch = {0, 5, 4, 8, 9, 5, 8, 4, 2, 5, 3, 9, 1};

      int s = 5;
      n = touch.length - 1;
      
      System.out.println("Here is the touch array: \n");
      for (int i = 1; i <= n; i++) 
         System.out.println("  touch[" + i + "] = " + touch[i]);
      
      System.out.println("\nHere are the paths: \n");
      for (int i = 1; i <= n; i++) {
         System.out.print("v" + 5 + " to v" + i + ":  ");
         Asst_5.dijkstraPrintPath(s, i, touch);
         System.out.println();
      }
      System.out.println();
   }
   
   
   public static void runProblem4() {

      System.out.println("\n======== Testing Problem 4 ============================================\n");
      // dijkstra
      int n;   
      
      n = D1.length - 1;
      testProblem_4(n, D1, 1);
      System.out.println();

      n = D2.length - 1;
      testProblem_4(n, D2, 7);
   }
   
   public static void runProblem5() {
   
      System.out.println("\n======== Testing Problem 5 ============================================\n");

      int k;
      
      int [] D1 = {-1, 1, 5, 10, 12};
      k = D1.length - 1;
      testProblem_5(16, k, D1);
      System.out.println();

      int [] D2 = {-1, 1, 3, 9, 12, 17, 29};
      k = D2.length - 1;
      testProblem_5(143, k, D2);
      System.out.println();

      int [] D3 = {-1, 1, 8, 13, 19};
      k = D3.length - 1;
      testProblem_5(54, k, D3);
      System.out.println();
   }
   
   public static void runProblem6() {

      System.out.println("\n======== Testing Problem 6 ============================================\n");
      int n;   

      int capacity;
      
      double [] profit1 = {-1, 50, 140, 60};
      double [] weight1 = {-1, 5, 20, 10};
      n = profit1.length - 1;
      capacity = 30;
      testProblem_6(n, capacity, profit1, weight1);
      
      double [] profit2 = {-1, 40, 30, 50, 10};
      double [] weight2 = {-1, 2, 5, 10, 5};
      n = profit2.length - 1;
      capacity = 11;
      testProblem_6(n, capacity, profit2, weight2);
            
      double [] profit3 = {-1, 20, 30, 35, 12, 3};
      double [] weight3 = {-1, 2, 5, 7, 3, 1};
      n = profit3.length - 1;
      capacity = 11;
      testProblem_6(n, capacity, profit3, weight3);
      
      capacity = 13;
      testProblem_6(n, capacity, profit3, weight3);


      double [] profit5 = {-1, 18, 30, 40, 21, 24};
      double [] weight5 = {-1, 3, 6, 10, 7, 12};
      n = profit5.length - 1;
      capacity = 25;
      testProblem_6(n, capacity, profit5, weight5);
      
      double [] profit6 = {-1, 320, 350, 900, 700, 650, 420, 504, 600, 150, 120};
      double [] weight6 = {-1, 85,95, 250, 200, 195, 140, 170, 230, 60, 50};
      n = profit6.length - 1;
      capacity = 405;
      testProblem_6(n, capacity, profit6, weight6);
   }
   
   public static void runProblem7() {

      System.out.println("\n======== Testing Problem 7 ============================================\n");
      int n;   
      
      int [] vcolor;
      
      n = coloring_1.length - 1;
      vcolor = new int[n+1];
      testProblem_7(n, coloring_1, vcolor);
      
      n = coloring_2.length - 1;
      vcolor = new int[n+1];
      testProblem_7(n, coloring_2, vcolor);

      n = coloring_3.length - 1;
      vcolor = new int[n+1];
      testProblem_7(n, coloring_3, vcolor);

      n = coloring_4.length - 1;
      vcolor = new int[n+1];
      testProblem_7(n, coloring_4, vcolor);
   }


   public static void testProblem_2(int n, int [][] W, int s, int [] nearest) {

      int cost = Asst_5.prim(n, W, s, nearest);
      System.out.print(cost + " is cost of MST. ");
      if (cost == -1)
         System.out.println("There is NO Spanning Tree for this graph!");
      else  {
         System.out.println("Here is the MST: ");
         Asst_5.printTree(n, nearest);
      }
      System.out.println();
   }
   
   public static void testProblem_4(int n, int [][] W, int s)  {
   
      int [] touch = new int [n+1];
      int [] pathCost = new int[n+1];
      
      Asst_5.dijkstra(n, W, s, touch, pathCost);
      System.out.println("Here is the touch array: \n");
      for (int i = 1; i <= n; i++) 
         System.out.println("  touch[" + i + "] = " + touch[i]);
      
      System.out.println("\nHere are the paths and costs: \n");
      
      for (int i = 1; i <= n; i++) {
         System.out.print("v" + s + " to v" + i + " (cost " + pathCost[i] + "):  ");
         Asst_5.dijkstraPrintPath(s, i, touch);
         System.out.println();
      }
      System.out.println();
   }
   
   
   public static void testProblem_5(int n, int k, int [] D) {

      System.out.print("Smart Greedy Coin Change with n = " + n + " cents, denominations: ");
      printArray(k, D);
      int [] Best = Asst_5.smarterGreedyAlgorithm1(n, k, D);
      System.out.println("Min number of coins needed is " + Best[0] + ":\n ");
      for (int i = k; i >= 1; i--)
         System.out.println(Best[i] + " coins of denomination " + D[i]);
         
      
      System.out.println();
   }


   public static void testProblem_6(int n, double capacity, double [] profit, double [] weight) {
   
      System.out.println("n = " + n + ", capacity = " + capacity);
      double [] quantity;

      for(int i = 1; i <= n; i++)
         System.out.println("Item " + i + ":  profit["+i+"] = " + profit[i] + ", weight["+i+"] = " + weight[i]);
         
      quantity = Asst_5.greedyFractionalKnapsack(n, capacity, profit, weight);
      System.out.println();
      System.out.printf("Greedy total profit: $%.2f, using:\n", quantity[0]);

      for(int i = 1; i <= n; i++) 
         if (quantity[i] > 0) {
            System.out.print("Item " + i + ":  ");
            if (quantity[i] == 1.0)
               System.out.println("all of it");
            else 
               System.out.printf("%.2f of it \n", quantity[i]);
         }
      System.out.println("\n");            
   }


   public static void testProblem_7(int n, int [][] W, int [] vcolor) {
   
      int numColors = Asst_5.greedyColoring(n, W, vcolor);
      System.out.println(numColors + " colors used by greedy algorithm, coloring: ");
      for (int i = 1; i <= n; i++) {
         System.out.println("v_" + i + ":  color " + vcolor[i]);
      }
      System.out.println();   
   }

      
   public static void printArray(int n, int [] A) {
      for (int i = 1; i <= n; i++)
         System.out.print(A[i] + " ");
      System.out.println();
   }

// =================== DATA =========================================
   
public static int inf = Integer.MAX_VALUE - 100000;
   
public static int [][] graph1 = 
   
{
{},
{0,0,45,9999,58,9999,80,49},
{0,45,0,60,9999,40,50,80},
{0,9999,60,0,70,55,25,9999},
{0,58,9999,70,0,95,90,63},
{0,9999,40,55,95,0,9999,72},
{0,80,50,25,90,9999,0,75},
{0,49,80,9999,63,72,75,0}
};   

public static int [][] g2 = 

{
{},
{5, 0,inf,inf,1,inf,1,inf,1},
{5, inf,0,1,inf,1,inf,1,inf},
{5, inf,1,0,inf,inf,1,inf,1},
{5, 1,inf,inf,0,1,inf,1,inf},
{5, inf,1,inf,1,0,inf,inf,1},
{5, 1,inf,1,inf,inf,0,1,inf},
{5, inf,1,inf,1,inf,1,0,inf},
{5, 1,inf,1,inf,1,inf,inf,0}
};


public static int[][] graph2 = 
{
{},
{0,0,inf,inf,150,inf,100,inf,123},
{0,inf,0,43,inf,35,inf,43,inf},
{0,inf,43,0,inf,inf,142,inf,71},
{0,150,inf,inf,0,61,inf,96,inf},
{0,inf,35,inf,61,0,inf,inf,50},
{0,100,inf,142,inf,inf,0,104,inf},
{0,inf,43,inf,96,inf,104,0,inf},
{0,123,inf,71,inf,50,inf,inf,0}
};


public static int [][] graph3 = 
{
{},
{0,0,10,15,inf,inf,12},
{0,10,0,20,inf,13,9},
{0,15,20,0,18,8,inf},
{0,inf,inf,18,0,inf,10},
{0,inf,13,8,inf,0,8},
{0,12,9,inf,10,8,0}
};


public static int [][] gg2 = 

{
{},
{1,0,inf,63,23,inf,inf,73,inf},
{2,inf,0,inf,inf,24,115,inf,134},
{3,84,inf,0,42,inf,inf,76,inf},
{4,102,inf,129,0,inf,inf,47,inf},
{5,inf,92,inf,inf,0,132,inf,79},
{6,inf,53,inf,inf,67,0,inf,148},
{7,103,inf,133,36,inf,inf,0,inf},
{8,inf,70,inf,inf,24,92,inf,0}
};


public static int [][] D1 =

{
{},
{1,0,inf,inf,200,40,inf,inf,140,inf},
{2,inf,0,100,inf,inf,inf,inf,40,inf},
{3,inf,inf,0,inf,inf,inf,90,inf,inf},
{4,inf,180,inf,0,inf,inf,50,inf,inf},
{5,inf,inf,50,inf,0,inf,inf,inf,20},
{6,140,inf,inf,inf,inf,0,inf,200,inf},
{7,30,inf,inf,450,inf,inf,0,inf,inf},
{8,inf,300,inf,150,inf,670,inf,0,inf},
{9,170,5550,90,inf,50,inf,90,inf,0}
};


public static int [][] D2 =

{
{}, 
{1,0,100,70,50,inf,170,inf,inf}, 
{2,100,0,140,40,20,inf,90,40}, 
{3,90,140,0,70,inf,inf,inf,inf}, 
{4,inf,40,70,0,inf,50,80,inf}, 
{5,45,30,inf,150,0,60,inf,100}, 
{6,170,inf,inf,20,60,0,inf,inf}, 
{7,inf,110,inf,80,inf,inf,0,40}, 
{8,inf,120,inf,70,inf,80,40,0}
};


public static int [][] coloring_1 = 
{
{},
{1,0,1,0,1,1,0,1,1,0},
{2,1,0,0,0,1,1,0,0,1},
{3,0,0,0,0,0,0,1,1,0},
{4,1,0,0,0,0,0,1,1,1},
{5,1,1,0,0,0,0,0,1,1},
{6,0,1,0,0,0,0,0,0,1},
{7,1,0,1,1,0,0,0,1,0},
{8,1,0,1,1,1,0,1,0,1},
{9,0,1,0,1,1,1,0,1,0}
};

public static int [][] coloring_2 = 
{
{},
{1,0,0,0,1,0,1,0,1},
{2,0,0,1,0,1,0,1,0},
{3,0,1,0,0,0,1,0,1},
{4,1,0,0,0,1,0,1,0},
{5,0,1,0,1,0,0,0,1},
{6,1,0,1,0,0,0,1,0},
{7,0,1,0,1,0,1,0,0},
{8,1,0,1,0,1,0,0,0}
};

public static int [][] coloring_3 = 
{
{},
{1,0,0,0,1,0,0,0,0,0},
{2,0,0,1,0,0,1,0,0,0},
{3,0,1,0,0,1,0,0,1,0},
{4,1,0,0,0,0,1,1,0,1},
{5,0,0,1,0,0,1,1,1,0},
{6,0,1,0,1,1,0,1,1,1},
{7,0,0,0,1,1,1,0,1,0},
{8,0,0,1,0,1,1,1,0,1},
{9,0,0,0,1,0,1,0,1,0}
};

public static int [][] coloring_4 = 
{
{},
{1,0,0,0,0,0,0,0,1,0,1,0,1},
{2,0,0,1,0,0,0,1,1,0,1,0,0},
{3,0,1,0,0,1,0,0,0,0,0,0,0},
{4,0,0,0,0,1,0,0,0,1,0,1,0},
{5,0,0,1,1,0,0,0,0,0,0,0,1},
{6,0,0,0,0,0,0,1,1,0,0,0,0},
{7,0,1,0,0,0,1,0,0,0,0,0,0},
{8,1,1,0,0,0,1,0,0,0,0,1,0},
{9,0,0,0,1,0,0,0,0,0,1,0,1},
{10,1,1,0,0,0,0,0,0,1,0,1,0},
{11,0,0,0,1,0,0,0,1,0,1,0,1},
{12,1,0,0,0,1,0,0,0,1,0,1,0}
};


} // end class
